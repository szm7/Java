
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author saninzulphi
 */
public class analytics extends javax.swing.JFrame {

    /**
     * Creates new form analytics
     */
    private Connection connection;

    /**
     * Creates new form analytics
     */
    public analytics() {
        initComponents();
        connectToDatabase();
        createAnalyticsDashboard();
        displayTopHashtags();
        displayMostLikedPosts();
        displayMostCommentedPosts();
        displayPostsByReach();
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/smAnalytics", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createAnalyticsDashboard() {
        // Example analytics: Display a bar chart of post views
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT postid, views FROM Analytics ORDER BY Views DESC LIMIT 5");

            while (resultSet.next()) {
                int postID = resultSet.getInt("PostID");
                int views = resultSet.getInt("Views");
                dataset.addValue(views, "Post Views", "Post " + postID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching analytics data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JFreeChart chart = ChartFactory.createBarChart("Top 5 Posts by Views", "Posts", "Views", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));

        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                if (event.getTrigger().getClickCount() == 2) {
                    JFreeChart chart = event.getChart();

                    if (chart.getTitle().getText().equals("Top 5 Posts by Views")) {
                        openPostsAndLikesWindow("Posts", "Views","SELECT postid, views FROM Analytics");
                    }
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                // Implement if needed
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(chartPanel, BorderLayout.NORTH);  // Refresh the layout
    }

    private void displayTopHashtags() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> topHashtagsList = new JList<>(listModel);
        topHashtagsList.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        topHashtagsList.setForeground(Color.DARK_GRAY);
        topHashtagsList.setBackground(Color.WHITE);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT tag FROM Hashtag ORDER BY tag LIMIT 5");
            listModel.addElement("Top 5 HashTags:");
            while (resultSet.next()) {
                String tagName = resultSet.getString("tag");
                listModel.addElement("#" + tagName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching hashtag data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(topHashtagsList);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        getContentPane().add(scrollPane, BorderLayout.SOUTH);
    }

//    private void displayMostLikedPosts() {
//    DefaultPieDataset dataset = new DefaultPieDataset();
//    try {
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT postid, likes FROM Post ORDER BY Likes DESC LIMIT 5");
//
//        while (resultSet.next()) {
//            int postID = resultSet.getInt("PostID");
//            int likes = resultSet.getInt("Likes");
//            dataset.setValue("Post " + postID, likes);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error fetching most liked posts data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
//    }
//
//    JFreeChart chart = ChartFactory.createPieChart("Most Liked Posts", dataset, true, true, false);
//    ChartPanel chartPanel = new ChartPanel(chart);
//    chartPanel.setPreferredSize(new Dimension(500, 300));
//
//    getContentPane().add(chartPanel, BorderLayout.CENTER);
//}
    private void displayMostLikedPosts() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT postid, likes FROM Post ORDER BY Likes DESC LIMIT 5");

            while (resultSet.next()) {
                int postID = resultSet.getInt("PostID");
                int likes = resultSet.getInt("Likes");
                dataset.setValue("Post " + postID, likes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching most liked posts data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JFreeChart chart = ChartFactory.createPieChart("Most Liked Posts", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));

        // Add ChartMouseListener using addChartMouseListener method
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                if (event.getTrigger().getClickCount() == 2) {
                    JFreeChart chart = event.getChart();

                    if (chart.getTitle().getText().equals("Most Liked Posts")) {
                        openPostsAndLikesWindow("Posts", "Likes","SELECT postid, likes FROM Post");
                    }
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                // Implement if needed
            }
        });

        getContentPane().add(chartPanel, BorderLayout.CENTER);
    }

    private void displayMostCommentedPosts() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT postid, comments FROM Post ORDER BY Comments DESC LIMIT 5");

            while (resultSet.next()) {
                int postID = resultSet.getInt("PostID");
                int comments = resultSet.getInt("Comments");
                dataset.addValue(comments, "Comments", "Post " + postID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching most commented posts data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JFreeChart chart = ChartFactory.createBarChart("Top 5 Posts by Comments", "Posts", "Comments", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                if (event.getTrigger().getClickCount() == 2) {
                    JFreeChart chart = event.getChart();

                    if (chart.getTitle().getText().equals("Top 5 Posts by Comments")) {
                        openPostsAndLikesWindow("Posts", "Comments","SELECT postid, comments FROM Post");
                    }
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                // Implement if needed
            }
        });

        getContentPane().add(chartPanel, BorderLayout.WEST);
    }

//    public void chartMouseClicked(ChartMouseEvent event) {
//        if (event.getTrigger().getClickCount() == 2) {
//            JFreeChart chart = event.getChart();
//
//            if (chart.getTitle().getText().equals("Most Liked Posts")) {
//                openPostsAndLikesWindow();
//            }
//        }
//    }
    private void openPostsAndLikesWindow(String fh, String lh, String sql) {
        JFrame postsAndLikesFrame = new JFrame(fh + " and " + lh);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        try {

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int postID = resultSet.getInt("PostID");
                    int value = resultSet.getInt(lh);
                    textArea.append("Post " + postID + " : " + lh + " " + value + "\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        postsAndLikesFrame.getContentPane().add(scrollPane);
        postsAndLikesFrame.setSize(600, 500);
        postsAndLikesFrame.setLocationRelativeTo(null);
        postsAndLikesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postsAndLikesFrame.setVisible(true);
    }

    private void displayPostsByReach() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT postid, reach FROM Analytics ORDER BY Reach DESC LIMIT 5");

            while (resultSet.next()) {
                int postID = resultSet.getInt("PostID");
                int reach = resultSet.getInt("Reach");
                dataset.addValue(reach, "Reach", "Post " + postID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching posts by reach data.", "Data Fetching Error", JOptionPane.ERROR_MESSAGE);
        }

        JFreeChart chart = ChartFactory.createLineChart("Top 5 Posts by Reach", "Posts", "Reach", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));

        chartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent event) {
                if (event.getTrigger().getClickCount() == 2) {
                    JFreeChart chart = event.getChart();

                    if (chart.getTitle().getText().equals("Top 5 Posts by Reach")) {
                        openPostsAndLikesWindow("Posts", "Reach", "SELECT postid, reach FROM Analytics");
                    }
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
                // Implement if needed
            }
        });

        getContentPane().add(chartPanel, BorderLayout.EAST);
    }

    // ... (Other methods for additional analytics)
    // Variables declaration - do not modify                     
    // End of variables declaration
    // Additional methods and variables can be added as needed
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(analytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new analytics().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
