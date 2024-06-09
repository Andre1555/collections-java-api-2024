package map;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class AgendaEventos {
        private Map<LocalDate, Evento> eventosMap;

        public AgendaEventos() {
            this.eventosMap = new HashMap<>();
        }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
            eventosMap.put(data, new Evento(nome, atracao));

        }
        public void exibirAgenda() {
            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                Evento evento = entry.getValue();
                System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
            }
        }

    public void obterProximoEvento() {

        LocalDate dataAtual = LocalDate.now();
        //podem tambem ser utilizados:
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                //proximaData = entry.getKey();
                //proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " + entry.getValue() + "acontecera na data" + entry.getKey());
                // System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
                        break;

            }
        }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
        } else {
            System.out.println("Não há eventos futuros na agenda.");
        }
    }

        public static void main(String[] args) {
            AgendaEventos agendaEventos = new AgendaEventos();

            // Adiciona eventos à agenda
            agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atração 1");
            agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Aração 2");
            agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 10), "Evento 3", "Atração 3");
            agendaEventos.adicionarEvento(LocalDate.of(2023, Month.JULY, 12), "Evento 4", "Atração 4");
            agendaEventos.adicionarEvento(LocalDate.of(2024, Month.SEPTEMBER, 20), "Evento 5", "Atração 5");

            // Exibe a agenda completa de eventos
            agendaEventos.exibirAgenda();

            // Obtém e exibe o próximo evento na agenda
            agendaEventos.obterProximoEvento();
        }
    }
