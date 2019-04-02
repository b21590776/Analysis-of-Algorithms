import java.io.IOException;


public class Assignment1 {

    public static void main(String[] args) {
		call("selection","worst");
        call("selection","avr");
		call("selection","best");

        call("insertion","best");
        call("insertion","avr");
        call("insertion","worst");

        call("merge","worst");
        call("merge","avr");
        call("merge","best");

        call("radix","worst");
        call("radix","avr");
        call("radix","best");

        call("binary","worst");
        call("binary","avr");
        call("binary","best");

    }

    public static void call(String sort, String order){
        try {
            WriteFile.append("begin " + order+ " " + sort );
        } catch (IOException e) {
            e.printStackTrace();
        }

        Compare.Sort(sort,order);

        try {
            WriteFile.append("end"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
