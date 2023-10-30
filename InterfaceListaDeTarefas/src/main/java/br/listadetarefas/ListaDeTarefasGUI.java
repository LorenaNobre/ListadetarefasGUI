package br.listadetarefas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaDeTarefasGUI {
    private ArrayList<String> tarefas = new ArrayList<>();
    private JFrame frame;
    private JTextArea tarefasTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ListaDeTarefasGUI window = new ListaDeTarefasGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ListaDeTarefasGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        tarefasTextArea = new JTextArea();
        tarefasTextArea.setEditable(false);
        tarefasTextArea.setBounds(10, 11, 414, 182);
        frame.getContentPane().add(tarefasTextArea);

        JTextField tarefaTextField = new JTextField();
        tarefaTextField.setBounds(10, 204, 258, 20);
        frame.getContentPane().add(tarefaTextField);
        tarefaTextField.setColumns(10);

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa(tarefaTextField.getText());
                tarefaTextField.setText("");
            }
        });
        adicionarButton.setBounds(278, 203, 89, 23);
        frame.getContentPane().add(adicionarButton);

        JButton removerButton = new JButton("Remover");
        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerTarefa();
            }
        });
        removerButton.setBounds(10, 235, 89, 23);
        frame.getContentPane().add(removerButton);

        JButton listarButton = new JButton("Listar");
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarTarefas();
            }
        });
        listarButton.setBounds(109, 235, 89, 23);
        frame.getContentPane().add(listarButton);
    }

    private void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
        atualizarListaTarefas();
    }

    private void removerTarefa() {
        if (!tarefas.isEmpty()) {
            tarefas.remove(tarefas.size() - 1);
            atualizarListaTarefas();
        }
    }

    private void listarTarefas() {
        atualizarListaTarefas();
    }

    private void atualizarListaTarefas() {
        StringBuilder listaTarefas = new StringBuilder();
        int i = 0;
        for (String tarefa : tarefas) {
            listaTarefas.append("Tarefa ").append(i).append(": ").append(tarefa).append("\n");
            i++;
        }
        tarefasTextArea.setText(listaTarefas.toString());
    }
}
