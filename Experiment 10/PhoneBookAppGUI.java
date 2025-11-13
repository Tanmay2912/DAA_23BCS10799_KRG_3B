import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    Set<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
}

class PhoneBook {
    private final TrieNode root;
    private final Map<String, List<String>> nameToNumber;

    public PhoneBook() {
        root = new TrieNode();
        nameToNumber = new LinkedHashMap<>();
    }

    public void addContact(String name, String number) {
        name = name.trim();
        number = number.trim();
        nameToNumber.putIfAbsent(name, new ArrayList<>());
        if (!nameToNumber.get(name).contains(number)) {
            nameToNumber.get(name).add(number);
        }
        insertIntoTrie(name);
    }

    private void insertIntoTrie(String name) {
        TrieNode current = root;
        for (char ch : name.toLowerCase().toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
            current.names.add(name);
        }
        current.isEndOfWord = true;
    }

    public List<String> searchByName(String name) {
        return nameToNumber.getOrDefault(name.trim(), new ArrayList<>());
    }

    public List<String> searchByPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(ch)) return new ArrayList<>();
            current = current.children.get(ch);
        }
        Set<String> resultSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        collectAllNames(current, resultSet);
        return new ArrayList<>(resultSet);
    }

    private void collectAllNames(TrieNode node, Set<String> result) {
        result.addAll(node.names);
        for (TrieNode child : node.children.values()) {
            collectAllNames(child, result);
        }
    }

    public void deleteContact(String name) {
        if (!nameToNumber.containsKey(name)) return;
        nameToNumber.remove(name);
        deleteFromTrie(name.toLowerCase(), root, 0, name);
    }

    private boolean deleteFromTrie(String name, TrieNode current, int index, String originalName) {
        if (index == name.length()) {
            current.names.remove(originalName);
            return current.children.isEmpty();
        }
        char ch = name.charAt(index);
        TrieNode child = current.children.get(ch);
        if (child == null) return false;

        boolean shouldDeleteChild = deleteFromTrie(name, child, index + 1, originalName);
        if (shouldDeleteChild) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }

        current.names.remove(originalName);
        return false;
    }

    public Map<String, List<String>> getAllContacts() {
        return new LinkedHashMap<>(nameToNumber);
    }

    public List<String> getNumber(String name) {
        return nameToNumber.getOrDefault(name, new ArrayList<>());
    }
}

public class PhoneBookAppGUI extends JFrame {
    private final PhoneBook phoneBook;
    private final JTextArea outputArea;

    public PhoneBookAppGUI() {
        phoneBook = new PhoneBook();
        outputArea = new JTextArea(12, 45);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBackground(new Color(245, 255, 250));
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        setTitle("📱 Stylish PhoneBook");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(230, 240, 255));

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Options"));
        panel.setBackground(new Color(224, 255, 255));

        JButton addBtn = new JButton("➕ Add Contact");
        JButton searchBtn = new JButton("🔍 Search by Name");
        JButton prefixBtn = new JButton("🔎 Search by Prefix");
        JButton deleteBtn = new JButton("🗑️ Delete Contact");
        JButton viewBtn = new JButton("📋 View All Contacts");
        JButton exitBtn = new JButton("🚪 Exit");

        JButton[] buttons = {addBtn, searchBtn, prefixBtn, deleteBtn, viewBtn, exitBtn};
        for (JButton btn : buttons) {
            btn.setBackground(new Color(173, 216, 230));
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            panel.add(btn);
        }

        addBtn.addActionListener(e -> addContactDialog());
        searchBtn.addActionListener(e -> searchByNameDialog());
        prefixBtn.addActionListener(e -> searchByPrefixDialog());
        deleteBtn.addActionListener(e -> deleteContactDialog());
        viewBtn.addActionListener(e -> viewAllContacts());
        exitBtn.addActionListener(e -> System.exit(0));

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addContactDialog() {
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        if (name == null || name.trim().isEmpty()) return;

        String number = JOptionPane.showInputDialog(this, "Enter Number:");
        if (number == null || number.trim().isEmpty()) return;

        phoneBook.addContact(name.trim(), number.trim());
        outputArea.setText("✅ Contact added: " + name + " - " + number);
    }

    private void searchByNameDialog() {
        String name = JOptionPane.showInputDialog(this, "Enter Name to Search:");
        if (name == null || name.trim().isEmpty()) return;

        List<String> numbers = phoneBook.searchByName(name.trim());
        if (!numbers.isEmpty()) {
            StringBuilder sb = new StringBuilder("📞 " + name + " :\n");
            for (String num : numbers) sb.append("   • ").append(num).append("\n");
            outputArea.setText(sb.toString());
        } else {
            outputArea.setText("❌ Contact not found.");
        }
    }

    private void searchByPrefixDialog() {
        String prefix = JOptionPane.showInputDialog(this, "Enter Prefix:");
        if (prefix == null || prefix.trim().isEmpty()) return;

        List<String> matches = phoneBook.searchByPrefix(prefix.trim());
        if (matches.isEmpty()) {
            outputArea.setText("❌ No contacts found with prefix: " + prefix);
        } else {
            StringBuilder sb = new StringBuilder("🔍 Matches for prefix \"" + prefix + "\":\n");
            for (String name : matches) {
                sb.append(" - ").append(name).append(" : ");
                List<String> nums = phoneBook.getNumber(name);
                sb.append(String.join(", ", nums)).append("\n");
            }
            outputArea.setText(sb.toString());
        }
    }

    private void deleteContactDialog() {
        String name = JOptionPane.showInputDialog(this, "Enter Name to Delete:");
        if (name == null || name.trim().isEmpty()) return;

        if (!phoneBook.searchByName(name.trim()).isEmpty()) {
            phoneBook.deleteContact(name.trim());
            outputArea.setText("🗑️ Deleted contact: " + name);
        } else {
            outputArea.setText("❌ Contact not found.");
        }
    }

    private void viewAllContacts() {
        Map<String, List<String>> all = phoneBook.getAllContacts();
        if (all.isEmpty()) {
            outputArea.setText("📭 No contacts saved.");
            return;
        }
        StringBuilder sb = new StringBuilder("📒 All Contacts:\n");
        for (Map.Entry<String, List<String>> entry : all.entrySet()) {
            sb.append(" - ").append(entry.getKey()).append(" : ");
            sb.append(String.join(", ", entry.getValue())).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhoneBookAppGUI::new);
    }
}