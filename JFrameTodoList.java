import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;

public class JFrameTodoList extends JFrame {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTodoList frame = new JFrameTodoList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameTodoList() {
		JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Heading
        JLabel headingLabel = new JLabel("To-Do List", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Task list panel
        JPanel taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskListPanel);

        // Add button
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e -> addTask(taskListPanel, frame));

        // Assemble
        mainPanel.add(headingLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(addButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void addTask(JPanel taskListPanel, JFrame frame) {
        JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JCheckBox checkBox = new JCheckBox();
        JTextField textField = new JTextField(20);
        JButton deleteButton = new JButton("Delete");

        deleteButton.addActionListener((ActionEvent e) -> {
            taskListPanel.remove(taskPanel);
            frame.revalidate();
            frame.repaint();
        });

        taskPanel.add(checkBox);
        taskPanel.add(textField);
        taskPanel.add(deleteButton);

        taskListPanel.add(taskPanel);
        frame.revalidate();
        frame.repaint();
    }
}