/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cinema;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author buto el que lo lea
 */
public class Tablamodelo extends JScrollPane {
     final ImageIcon image = new ImageIcon(getClass().getResource("/Img/cartelera.jpg"));

    private JTable table;

    /**
     * Constructor de clase
     */
    public Tablamodelo() {
        super();

        Tablamodelo.this.setOpaque(false);
        Tablamodelo.this.getViewport().setOpaque(false);

        table = new JTable() {
            {
                setOpaque(false);
                setShowVerticalLines(false);
                setShowHorizontalLines(true);
                //render de celdas
                setDefaultRenderer(Object.class, new CeldalRenderer());
               //render de encabezado
                getTableHeader().setDefaultRenderer(new EncabezadoRenderer());
            }
        };

        Tablamodelo.this.setViewportView(table);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(g);
    }

    /**
     * Clase para manejar la apariencia de las celdas de la tabla
     */
    private class CeldalRenderer extends DefaultTableCellRenderer {

        public CeldalRenderer() {
            CeldalRenderer.this.setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                setBackground(new Color(255,255,255));
                setOpaque(true);
                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0,0,0)));
                setFont(new Font("Consolas", Font.BOLD, 12));
            } else {
                setOpaque(false);
                setFont(new Font("Consolas", Font.PLAIN, 12));
                setBorder(null);
            }
            return cellComponent;

        }
    }

    /**
     * Clase para menajar el encabezado de la tabla
     */
    private class EncabezadoRenderer extends JLabel implements TableCellRenderer {

        public EncabezadoRenderer() {
            EncabezadoRenderer.this.setHorizontalAlignment(SwingConstants.CENTER);
            EncabezadoRenderer.this.setFont(new Font("Consolas", Font.BOLD, 14));
            EncabezadoRenderer.this.setForeground(new Color(255, 255, 255));
            EncabezadoRenderer.this.setBackground(new Color(0,0,0));
            EncabezadoRenderer.this.setOpaque(true);                
            EncabezadoRenderer.this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }

    }

}
