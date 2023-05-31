import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Paciente {
    private String nome;
    private String cpf;
    private int prioridade;

    public Paciente(String nome, String cpf, int prioridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getPrioridade() {
        return prioridade;
    }
}

class GestaoHospital {
    private Queue<Paciente> filaNormal;
    private Queue<Paciente> filaLeve;
    private Queue<Paciente> filaModerado;
    private Queue<Paciente> filaSevero;

    public GestaoHospital() {
        filaNormal = new LinkedList<>();
        filaLeve = new LinkedList<>();
        filaModerado = new LinkedList<>();
        filaSevero = new LinkedList<>();
    }

    public void adicionarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a prioridade do paciente (0 - normal, 1 - leve, 2 - moderado, 3 - severo): ");
        int prioridade = scanner.nextInt();

        Paciente paciente = new Paciente(nome, cpf, prioridade);

        switch (prioridade) {
            case 0:
                filaNormal.offer(paciente);
                break;
            case 1:
                filaLeve.offer(paciente);
                break;
            case 2:
                filaModerado.offer(paciente);
                break;
            case 3:
                filaSevero.offer(paciente);
                break;
            default:
                System.out.println("Prioridade inválida!");
        }

        System.out.println("Paciente adicionado com sucesso!");
    }

    public void atenderProximoPaciente() {
        if (!filaSevero.isEmpty()) {
            Paciente paciente = filaSevero.poll();
            System.out.println("Atendendo paciente:");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Prioridade: " + paciente.getPrioridade());
        } else if (!filaModerado.isEmpty()) {
            Paciente paciente = filaModerado.poll();
            System.out.println("Atendendo paciente:");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Prioridade: " + paciente.getPrioridade());
        } else if (!filaLeve.isEmpty()) {
            Paciente paciente = filaLeve.poll();
            System.out.println("Atendendo paciente:");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Prioridade: " + paciente.getPrioridade());
        } else if (!filaNormal.isEmpty()) {
            Paciente paciente = filaNormal.poll();
            System.out.println("Atendendo paciente:");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Prioridade: " + paciente.getPrioridade());
        } else {
            System.out.println("Não há pacientes na fila!");
        }
    }

    public void exibirNumeroPacientesFila() {
        int total
