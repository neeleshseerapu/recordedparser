package org.example;//package org.firstinspires.ftc.teamcode.Auto;


public class RecordedParser {

    /*
    Format: in = "{{1,2,3,4,5,...},{1,2,3,4,5,...},...}"
     */
    public static double[][] parse(String in) {
        // neelesh fire code
        double[][] parsed;
        int rows;
        int braces=0;

        for (int i = 0; i < in.length(); i++){
            char a = in.charAt(i);
            if (a=='{' || a=='}')
                braces += 1;
        }
        rows = (braces-2)/2;

        int columns;
        int commas = 0;

        for (int i = 0; i < in.indexOf('}'); i++){
            if (in.charAt(i)==',') {
                commas += 1;
            }
        }
        columns = commas+1;

//        System.out.println(rows + " x " + columns);

        parsed = new double[rows][columns];

        // kosei fire code
        int r = -2;
        int c = 0;
        String current = "";
        for (int i = 0; i < in.length(); i++){
            char a = in.charAt(i);
            if (a == '{') {
                r++;
                c = 0;
            } else if (a == ',') {
                c++;
                parsed[r][c] = Double.parseDouble(current);
            } else if (a == '}') {
                parsed[r][c] = Double.parseDouble(current);
            } else {
                current = current + a;
            }

        }

        return parsed;
    }

    public static void main(String[] args) {
//        double[][] parsed = parse("{{1,2,3},{4,5,6}}");

        double[][] parsed = {{1,2,3},{4,5,6},{7,8,9}};
        // -> "{{1,2,3},{4,5,6}}"

        String pString = "{";
        for (int i = 0; i < parsed.length-1; i++) {
            pString += "{";
            for (int i2 = 0; i2 < parsed[i].length-1; i2++) {
                pString += parsed[i][i2]+",";
            }
            //last column
            pString += parsed[i][parsed[i].length-1]+"},";
        }

        //last row
        pString += "{";
        for (int i = 0; i < parsed[parsed.length-1].length-1; i++) {
            pString += parsed[parsed.length-1][i]+",";
        }
        pString += parsed[parsed.length-1][parsed[parsed.length-1].length-1] + "}";

        pString += "}";

        System.out.println(pString);
    }

}
