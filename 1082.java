import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


//ALunos:
//- Lucas Eduardo
//- Marco Aurélio
public class Main {

    //Esse é o arquivo de componentes conexos

    //Foi feito em 1 arquivo para que seja possível a execução no URI Online
    public static void main(String[] args) throws IOException {


			//INICIO LEITURA CONSOLE
        Scanner leitor = new Scanner(System.in);

        ArrayList<String> arrayLines = new ArrayList<>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = stdin.readLine()) != null && line.length() != 0) {
            arrayLines.add(line);
        }

        String[] lines = new String[arrayLines.size()];

        int arrayCounter = 0;
        for (String linha : arrayLines) {
            lines[arrayCounter] = linha;
            arrayCounter++;
        }

				leitor.close();

				//FIM LEITURA CONSOLE

        int testCaseAmount = Integer.parseInt(lines[0]);
        Graph[] tests = new Graph[testCaseAmount];

        int iter = 1;
        for (int i = 0; i < tests.length; i++) {
            String[] amounts = lines[iter].split(" ");
            iter++;
            int vAmount = Integer.parseInt(amounts[0]);
            int eAmount = Integer.parseInt(amounts[1]);

            tests[i] = new Graph(vAmount, null, false);

            for (int j = 0; j < eAmount; j++) {
                tests[i].addAdjacentBothWays(lines[j + iter].charAt(0),
                        lines[j + iter].charAt(2), 1);
            }
            iter += eAmount;
        }
        ConnectedComponentFinder[] ccfs = new ConnectedComponentFinder[testCaseAmount];
        for (int i = 0; i < testCaseAmount; i++) {
            ccfs[i] = new ConnectedComponentFinder(tests[i]);
            System.out.print("Case #" + ((int) i + 1) + ":\n");
            System.out.print(ccfs[i].getConnectedComponents().replace("0",
                    "\n"));
            System.out.print(ccfs[i].getConnectedComponentsAmount()
                    + " connected components\n\n");
        }

    }

}

class ConnectedComponentFinder {

    private Graph graph;
    private int ccAmount;
    private String connectedComponents = "";

    public ConnectedComponentFinder(Graph graph) {
        this.graph = graph;
        ccAmount = 0;
        findConnectedComponents();
    }

    public void findConnectedComponents() {
        Vertice[] vertices = graph.getVertices();
        for (Vertice vertice : vertices) {
            if (vertice.getFather() == null) {
                ccAmount++;
                walkOnAdjacents(vertice);
                connectedComponents += "0";
            }
        }
        orderConnectedComponents();
    }

    private void walkOnAdjacents(Vertice vertice) {
        connectedComponents += vertice.getLabel() + ",";
        vertice.setFather(vertice);
        for (Vertice adjacent : vertice.getAdjacents().keySet()) {
            if (adjacent.getFather() == null) {
                adjacent.setFather(vertice);
                walkOnAdjacents(adjacent);
            }
        }
    }

    private void orderConnectedComponents() {
        String old = connectedComponents;
        connectedComponents = "";
        for (String connComp : old.split("0")) {
            String[] sorted = connComp.split(",");
            Arrays.sort(sorted);
            for (String string : sorted) {
                connectedComponents += string + ",";
            }
            connectedComponents += "0";
        }
    }

    public int getConnectedComponentsAmount() {
        return ccAmount;
    }

    public String getConnectedComponents() {
        return connectedComponents;
    }
}

///Classe grafo
class Graph {

    private int verticeAmount;
    private Vertice[] vertices;
    int letterStart = 0;
    int curLetter;

    public Graph(int verticeAmount, int[][] costs, boolean uppercase) {
        if (uppercase) {
            letterStart = 65;
        } else {
            letterStart = 97;
        }
        curLetter = letterStart - 1;

        this.verticeAmount = verticeAmount;
        vertices = new Vertice[verticeAmount];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertice(nextLetter());
        }
        if (costs != null) {
            for (int i = 0; i < vertices.length; i++) {
                for (int j = 0; j < costs[i].length; j++) {
                    if (costs[i][j] < Integer.MAX_VALUE
                            && vertices[i] != vertices[j]) {
                        vertices[i].addAdjacent(vertices[j], costs[i][j]);
                    }
                }
            }
        }
    }

    private int[] getDefaultCosts(int pos) {
        int[] defCost = new int[verticeAmount];
        for (int i = 0; i < defCost.length; i++) {
            defCost[i] = Integer.MAX_VALUE;
        }
        defCost[pos] = 0;
        return defCost;
    }
    private char nextLetter() {
        if (curLetter > letterStart + 25) {
            //Acabou alfabeto
            return 0;
        }
        curLetter++;
        return (char) curLetter;
    }

    public int getPositionByLabel(char label) {
        return ((int) label) - letterStart;
    }

    public Vertice getVerticeAt(int pos) {
        return vertices[pos];
    }

    public int getVerticeAmount() {
        return verticeAmount;
    }

    public void addAdjacent(char labelStart, char labelEnd, int cost) {
        vertices[getPositionByLabel(labelStart)].addAdjacent(
                vertices[getPositionByLabel(labelEnd)], cost);
    }

    public void addAdjacentBothWays(char labelStart, char labelEnd, int cost) {
        vertices[getPositionByLabel(labelStart)].addAdjacent(
                vertices[getPositionByLabel(labelEnd)], cost);
        vertices[getPositionByLabel(labelEnd)].addAdjacent(
                vertices[getPositionByLabel(labelStart)], cost);
    }

    public Vertice[] getVertices() {
        return vertices;
    }
}

//Classe vertice
class Vertice {

    private char label;
    private HashMap<Vertice, Integer> adjacents;
    private Vertice father;

    public Vertice(char label) {
        this.label = label;
        adjacents = new HashMap<>();
    }

    public void addAdjacent(Vertice a, Integer cost) {
        adjacents.put(a, cost);
    }

    public void removeAdjacent(Vertice a) {
        adjacents.remove(a);
    }

    public char getLabel() {
        return label;
    }

    public HashMap<Vertice, Integer> getAdjacents() {
        return adjacents;
    }

    public Vertice getFather() {
        return father;
    }

    public void setFather(Vertice father) {
        this.father = father;
    }

    public int getCost(Vertice vertice) {
        Integer cost = adjacents.get(vertice);
        return cost == null ? Integer.MAX_VALUE : cost;
    }

}
