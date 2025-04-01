import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PathfindingBFS_GUI extends JPanel implements MouseListener, ActionListener {
    private static final int ROWS = 20, COLS = 20, CELL_SIZE = 25;
    private Point start = null, end = null;
    private boolean[][] visited = new boolean[ROWS][COLS];
    private JButton bfsButton = new JButton("Run BFS");

    public PathfindingBFS_GUI() {
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        addMouseListener(this);
        bfsButton.addActionListener(this);
        JFrame frame = new JFrame("Pathfinding Visualizer - BFS");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(bfsButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (start != null && start.x == c && start.y == r) {
                    g.setColor(Color.GREEN);
                } else if (end != null && end.x == c && end.y == r) {
                    g.setColor(Color.RED);
                } else if (visited[r][c]) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / CELL_SIZE;
        int row = e.getY() / CELL_SIZE;
        if (start == null) {
            start = new Point(col, row);
        } else if (end == null) {
            end = new Point(col, row);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (start == null || end == null) return;
        bfs();
        repaint();
    }

    private void bfs() {
        Queue<Point> queue = new LinkedList<>();
        Map<Point, Point> parent = new HashMap<>();
        visited = new boolean[ROWS][COLS];

        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Point node = queue.poll();
            if (node.equals(end)) break;

            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nr = node.y + dir[0], nc = node.x + dir[1];
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nc, nr));
                    parent.put(new Point(nc, nr), node);
                    repaint();
                    try { Thread.sleep(20); } catch (InterruptedException ex) {} // Smooth Animation
                }
            }
        }
        drawPath(parent);
    }

    private void drawPath(Map<Point, Point> parent) {
        Point node = end;
        while (parent.containsKey(node)) {
            node = parent.get(node);
            if (!node.equals(start) && !node.equals(end)) {
                visited[node.y][node.x] = false;
                Graphics g = getGraphics();
                g.setColor(Color.YELLOW);
                g.fillRect(node.x * CELL_SIZE, node.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(node.x * CELL_SIZE, node.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                try { Thread.sleep(50); } catch (InterruptedException ex) {}
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PathfindingBFS_GUI::new);
    }

    // Unused MouseListener Methods
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
