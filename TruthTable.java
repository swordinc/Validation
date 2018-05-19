package Discrete;

import java.util.ArrayList;
import java.util.List;

public abstract class TruthTable {

    boolean[] variables;
    private List<Boolean> rows;
    private int numRows;

    public TruthTable() {
        init(getNumVariables());
    }

    private TruthTable init(int numVariables) {
        variables = new boolean[numVariables];
        numRows = ((int)Math.pow(2, variables.length));
        rows = new ArrayList<Boolean>(numRows);
        return this;
    }

    public TruthTable compute() {
        rows.clear();
        for (int i=0; i < numRows; i++) {
            for (int j=variables.length -1; j >= 0; j--) {
                variables[j] = (i / (int)Math.pow(2, j)) % 2 == 0;
            }
            boolean rowOutput = expression();
            rows.add(rowOutput);
        }
        return this;
    }

    public boolean equals(Object other) {
        if (numRows != ((TruthTable)other).numRows) return false;

        compute();
        ((TruthTable)other).compute();

        for (int i=0; i < rows.size(); i++) {
            if (rows.get(i) != ((TruthTable)other).rows.get(i)) return false;
        }

        return true;
    }

    public int getNumVariables() {
    	
    	return 4;
    	
    }
    public  boolean expression() {
    	
    	return true;
    	
    }

    public static void main(String[] args) {
        TruthTable t1 = new TruthTable() {
            public int getNumVariables() {
                return 2;
            }
            public boolean expression() {
                return !(variables[0] && variables[1]);
            }
        };

        TruthTable t2 = new TruthTable() {
            public int getNumVariables() {
                return 2;
            }
            public boolean expression() {
                return (!variables[0] || !variables[1]);
            }
        };

        System.out.println(t1.equals(t2));
    }
}