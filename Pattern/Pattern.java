// First Download this pdf and try by yourself then you can take help from solutions
// --> https://drive.google.com/file/d/1pOFPlGU0hWHPQFKCkJ0qlLm_vnamuvqv/view?usp=sharing


// Desclaimer - I am still a learner, so there may be bugs in my solutions or opportunities for optimization.

//If you come across any improvements, I would greatly appreciate it if you could submit a pull request with the updated code, as it will be helpful for both me and others.



import java.util.Scanner;

package Pattern;

public class Pattern {
    

    public static void main(String[] args) {
        
        // for input of rows
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Rows:- ");
        int rows = sc.nextInt();

        while (rows < 3) {
            System.out.print("Enter wrong input try again (at least 2):- ");
            rows = sc.nextInt();
        }

        sc.close(); 




        // --> Question - 1
        System.out.println("\n\nQuestion - 1: ");

        for(int i = 0; i < rows; i++){ // 1st - method
            for(int j = 0; j < rows; j++){
                System.out.print("*");
            }
            System.out.println();
        }   

        System.out.println();

        // 2-nd method
        for (int i = 0; i < rows; i++) {
            System.out.println("*".repeat(rows));
        }



        
        // --> Question - 2
        System.out.println("\n\nQuestion - 2: ");

        for(int i = 0; i < rows; i++){ // 1st-method
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();


        // 2nd-method
        for (int i = 1; i <= rows; i++) {
            System.out.println("*".repeat(i));
        }

        


        // --> Question - 3
        System.out.println("\n\nQuestion - 3: ");

        for(int i = rows; i > 0; i--){ // first method
            for(int j = i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();   

        // second method
        for(int i = rows; i > 0; i--){ 
            System.out.println("*".repeat(i));
        }




        // Question - 4
        System.out.println("\n\nQuestion - 4: ");

        for(int i = 1; i <= rows; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }





        // Question - 5
        System.out.println("\n\nQuestion - 5: ");

        for (int i = 0; i < (rows * 2) ; i++) { // 1st-method
            int dummyVar = 0;

            if (i < rows) {
                dummyVar = i;
            }
            else{
                dummyVar = ((rows * 2) - i);
            }

            for (int j = 0; j < dummyVar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println();
        // 2nd method
        for (int i = 0; i < (rows * 2); i++) {
            int dummyVar = 0;

            if (i < rows) {
                dummyVar = i;
            }
            else{
                dummyVar = (rows*2) - i;
            }

            System.out.println("*".repeat(dummyVar));
        }




        // Question - 6
        System.out.println("\n\nQuestion - 6: ");

        for (int i = 0; i < rows; i++) { // first method

            // for space
            for(int space = 1; space < (rows - i); space++){
                System.out.print(" ");
            }

            // for star
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();


        // 2nd -method
        for(int i = 1; i <= rows; i++){
            System.out.print(" ".repeat(rows - i));
            System.out.println("*".repeat(i));
        }




        
        // Question - 7
        System.out.println("\n\nQuestion - 7: ");

        for (int i = 0; i < rows; i++) {   // 1st-method
            
            // for space
            for (int space = 0; space < i; space++) {
                System.out.print(" ");
            }

            // for star
            for(int j = 0; j < rows - i; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();


        // 2nd-method
        for (int i = 0; i < rows; i++) {
            System.out.print(" ".repeat(i));
            System.out.println("*".repeat(rows - i));
        }




        // Question - 8
        System.out.println("\n\nQuestion - 8: ");

        for (int i = 0; i < rows; i++) { // first method

            // for space
            for (int space = rows - i - 1; space > 0; space--) {
                System.out.print(" ");
            }


            // for star
            int dummyVar = (i * 2) + 1;
            for (int j = 0; j < dummyVar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();


        // 2nd-method
        for (int i = 0; i < rows; i++) {
            System.out.print(" ".repeat(rows - i - 1));
            System.out.println("*".repeat((i*2) + 1));
        }





        // Question - 9
        System.out.println("\n\nQuestion - 9: ");

        for (int i = 0; i < rows; i++) { // first method


            // for space
            for(int space = 0; space < i; space++){
                System.out.print(" ");
            }


            // for star
            int dummyVar = (rows * 2) - (i * 2) - 1;

            for (int j = 0; j < dummyVar; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();


        // 2nd-method
        for (int i = 0; i < rows; i++) {
            System.out.print(" ".repeat(i));
            System.out.println("*".repeat((rows * 2)- (i *2) - 1));
        }






        // Question - 10
        System.out.println("\n\nQuestion - 10: ");

        for (int i = 1; i <= rows; i++) { // 1st-method
            
            // for space
            for(int space = rows - i; space > 0; space--){
                System.out.print(" ");
            }


            // for star
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        System.out.println();

        // 2nd method
        for (int i = 1; i <= rows; i++) {
            System.out.print(" ".repeat(rows - i));
            System.out.println("* ".repeat(i));
        }






        // Question - 11
        System.out.println("\n\nQuestion - 11: ");

        for (int i = 0; i < rows; i++) {  // 1st-method
            
            // for space
            for(int space = 0; space < i; space++){
                System.out.print(" ");
            }

            // for star
            for (int j = 0; j < rows - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


        System.out.println();


        // 2nd-method
        for (int i = 0; i < rows; i++) {
            System.out.print(" ".repeat(i));
            System.out.println("* ".repeat(rows - i));
        }





        // Question - 12
        System.out.println("\n\nQuestion - 12: ");

        for (int i = 0; i < (rows * 2); i++) {
            
            // for space
            int space = 0;
            if (i < rows) {
                space = i;
            }
            else{
                space = (rows * 2) - i - 1;
            }

            for( ; space > 0; space--){
                System.out.print(" ");
            }


            // for star
            int j = 0;
            if (i < rows) {
                j = rows - i;
            }
            else{
                j = (i - rows) + 1;
            }
            for( ; j > 0; j--){
                System.out.print("* ");
            }

            System.out.println();
        }


        System.out.println();

        // 2nd-method
        for (int i = 0; i < (rows * 2); i++) {
            
            // for space
             int space = 0;
            if (i < rows) {
                space = i;
            }
            else{
                space = (rows * 2) - i - 1;
            }
            System.out.print(" ".repeat(space));

            // for star
            int j = 0;
            if (i < rows) {
                j = rows - i;
            }
            else{
                j = (i - rows) + 1;
            }
            System.out.println("* ".repeat(j));
        }





        // Question - 13
        System.out.println("\n\nQuestion - 13: ");

        int dummyVar = 0;
        for (int i = 1; i < rows; i++) {// first method
            
            // for outer space
            for(int outerSpace = 0; outerSpace < rows - i; outerSpace++){
                System.out.print(" ");
            }

            System.out.print("*");

            // for inner space
            for(int innerSpace = 1; innerSpace < dummyVar; innerSpace++){
                System.out.print(" ");
            }
            dummyVar += 2;


            if (i > 1) {
                System.out.print("*");
            }
            
            System.out.println();
        }

        for (int i = 0; i < (rows * 2) - 1; i++) {
            System.out.print("*");
        }


        System.out.println("\n");


        // 2nd method
        dummyVar = 1;
        for (int i = 1; i < rows; i++) {
            System.out.print(" ".repeat(rows - i));
            System.out.print("*");

           
            if (i > 1) {
                System.out.print(" ".repeat(dummyVar)); dummyVar += 2;
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println("*".repeat((rows * 2) - 1));






        // Question - 14
        System.out.println("\n\nQuestion - 14: ");

        for (int i = 0; i < (rows * 2) - 1; i++) {
            System.out.print("*");
        }
        System.out.println();
        dummyVar = (rows * 2) - 5;
        for (int i = 1; i < rows; i++) {

            // for outer space
            for(int outerSpace = 0; outerSpace  < i; outerSpace++){
                System.out.print(" ");
            }
            
            System.out.print("*");


            // for inner space
            for(int innerSpace = 0; innerSpace < dummyVar; innerSpace++){
                System.out.print(" ");
            }
            dummyVar -= 2;

            if (i < rows - 1) {
                System.out.println("*");
            }
        }


        System.out.println("\n");




        // 2nd - method
        System.out.println("*".repeat((rows *2) - 1));

        dummyVar = (rows * 2) - 5;
        for (int i = 1; i < rows-1; i++) {
            System.out.print(" ".repeat(i));
            System.out.print("*");
            System.out.print(" ".repeat(dummyVar));  dummyVar -= 2;
            System.out.println("*");
        }

        System.out.println(" ".repeat(rows - 1) + "*");





        // Question - 15
        System.out.println("\n\nQuestion - 15: ");

        dummyVar = 1;
        System.out.println(" ".repeat(rows - 1) + "*");

        for (int i = 1; i < (rows * 2) - 2 ; i++) {
             // for outer space
            int outerSpace = 0;
            if (i < rows-1) {
                outerSpace = rows - i - 1;
            }
            else{
                outerSpace = (i - rows) + 1 ;
            }

            while (outerSpace > 0) {
                System.out.print(" ");
                outerSpace--;
            }

            System.out.print("*");

            //for inner space
            for (int innerSpace = 0; innerSpace < dummyVar; innerSpace++) {
                System.out.print(" ");
            }
            if (i < rows - 1) {
                dummyVar += 2;
            }
            else{
                dummyVar -= 2;
            }

            System.out.println("*");
        }
        System.out.println(" ".repeat(rows - 1) + "*");


        System.out.println("\n");
        // 2nd-method
        dummyVar = 1;
        System.out.println(" ".repeat(rows - 1) + "*");

        for (int i = 1; i < (rows * 2) - 2; i++) {

            // for outer space
            int outerSpace = 0;
            if (i < rows-1) {
                outerSpace = rows - i - 1;
            }
            else{
                outerSpace = (i - rows) + 1 ;
            }

            System.out.print(" ".repeat(outerSpace) + "*");
            

            //for inner space
            System.out.print(" ".repeat(dummyVar));
            if (i < rows - 1) {
                dummyVar += 2;
            }
            else{
                dummyVar -= 2;
            }

            System.out.println("*");
        }
        System.out.println(" ".repeat(rows - 1) + "*");






        // Question - 16
        System.out.println("\n\nQuestion - 16: ");

        for (int i = 0; i < rows; i++) {
            
            // for outer space
            for(int space = 0; space < rows - i - 1; space++){
                System.out.print("  ");
            }


            // main pascal's triangle
            int n = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(n + "   ");
                n = n * (i - j)/(j + 1);
            }
            System.out.println();
        }





        // Question - 17
        System.out.println("\n\nQuestion - 17: ");

        for (int i = (rows * 2) - 1; i > 0; i--) {

            // for space
            int space = (i > rows) ? i - rows : rows - i;

            while (space > 0) {
                System.out.print(" ");
                space--;
            }


            int val = (i > rows) ? (rows * 2) - i : i;

            int dummyVal = val;
            int size = -val;
            while (size != (val-1)){
                System.out.print(dummyVal + "");

                size++;
                if (size < 0) {
                    dummyVal--;
                }
                else{
                    dummyVal++;
                }

            }
            System.out.println();
        }






        // Question - 18(
        System.out.println("\n\nQuestion - 18: ");

        dummyVar = -2;
        for (int i = 0; i < (rows * 2)-1; i++) { // Note- you can also make it using  1st half, then second half
            
            // for left side stars
            int stardummyVar = 0;
            if(i < rows){
                stardummyVar = rows - i;
            }
            else{
                stardummyVar = (i - rows)+2;
            }
            for(int star = 0; star < stardummyVar; star++){
                System.out.print("*");
            }


            // for inner space
            if (i < rows) {
                dummyVar += 2;
            }
            else{
                dummyVar -= 2;
            }


            for (int space = 0; space < dummyVar; space++) {
                System.out.print(" ");   
            }


            // for right side stars
            if(i < rows){
                stardummyVar = rows - i;
            }
            else{
                stardummyVar = (i - rows)+2;
            }

            for(int star = 0; star < stardummyVar; star++){
                System.out.print("*");
            }

            System.out.println();
        }




        // Question - 19
        System.out.println("\n\nQuestion - 19: ");

        dummyVar = (rows *2) - 2;
        for (int i = 1; i < (rows * 2); i++) {
            

            // for left side stars
            int starsdummyVar = 0;
            if (i < rows) {
                starsdummyVar = i;
            }
            else{
                starsdummyVar = (rows *2) - i;
            }

            for(int stars = 0; stars < starsdummyVar; stars++){
                System.out.print("*");
            }


            // for inner space
            for(int space = 0; space < dummyVar; space++){
                System.out.print(" ");
            }

            if (i < rows) {
                dummyVar -= 2;
            }
            else{
                dummyVar += 2;
            }

            // for right side stars
            if (i < rows) {
                starsdummyVar = i;
            }
            else{
                starsdummyVar = (rows *2) - i;
            }

            for(int stars = 0; stars < starsdummyVar; stars++){
                System.out.print("*");
            }

            System.out.println();
        }





        // Question - 20
        System.out.println("\n\nQuestion - 20: ");

        for (int i = 0; i < rows; i++) {
            System.out.print("*");

            String s = " ";

            if (i == 0 || i == rows -1) {
                s = "*";
            }
            
            // main func
            for(int j = 0; j < rows - 2; j++){
                System.out.print(s);
            }
            System.out.println("*");
        }

        System.out.println();

        // 2nd-method
        for (int i = 0; i < rows; i++) {
            System.out.print("*");

            String s = "";
            if (i == 0 || i == rows - 1) {
                s = "*";
            }
            else{
                s = " ";
            }

            // main func
            System.out.println(s.repeat(rows - 2) + "*");
        }





        // Question - 21
        System.out.println("\n\nQuestion - 21: ");

        int counter = 1;
        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }

        
        



      // Question - 22
      System.out.println("\n\nQuestion - 22: ");

        int[] ques22 = {0,1,0};
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                if (i %2 != 0) {
                    System.out.print(ques22[(j%2) + 1] + " ");
                }
                else{
                    System.out.print(ques22[j%2] + " ");
                }
            }
            System.out.println();
        }

    
        


        // Question - 23
        System.out.println("\n\nQuestion - 23");

        dummyVar = rows -1;
        for (int i = 0; i < (rows * 2); i += 2) {
            
            // for outer space of left side
            for(int outerSpace = 0; outerSpace < dummyVar; outerSpace++){
                System.out.print(" ");
            }

            System.out.print("*");

            if (dummyVar == rows - 1) {
                System.out.print(" ");
            }
            dummyVar--;
            // for inner space of mountain 1
            for(int innerSpace = 0; innerSpace < i; innerSpace++){
                System.out.print(" ");
                if (innerSpace == i-1) {
                    System.out.print("*");
                }
            }


            // for outer space of right side of first mountain (or space between two mountains)
            for(int outerSpace = 0; outerSpace < (rows*2)-i; outerSpace++){
                System.out.print(" ");
            }
            System.out.print("*");


            // for inner space of mountain 1
            for(int innerSpace = 0; innerSpace < i; innerSpace++){
                System.out.print(" ");
                if (innerSpace == i-1) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }


        System.out.println();


        // 2nd-method
        dummyVar = rows - 1;
        System.out.println(" ".repeat(dummyVar--) + "*" + " ".repeat((rows *2) + 1) + "*"); // first line of pattern

        for (int i = 2; i < (rows * 2); i += 2) {
            // for outer space
            System.out.print(" ".repeat(dummyVar--) + "*");

            // for inner space of mountain 1
            System.out.print(" ".repeat(i) + "*");

            // for space between two mountains
            System.out.print(" ".repeat((rows * 2) - i) + "*");

            // for inner space of mountain 2
            System.out.println(" ".repeat(i) + "*");
        }





        // Question - 24
        System.out.println("\n\nQuestion - 24: ");

        int n24 = (rows *2);
        for (int i = 1; i <= n24; i++) {

            int col = i <= rows ? i : n24 - i + 1;
            // 1st pattern
            for(int j = 0; j <= col; j++){
                if (j == 1 || j == col) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }

            // for space between two patterns
            int outerSpace = (rows - col) * 2;
            while (outerSpace > 0) {
                System.out.print(" ");
                outerSpace--;
            }


            // 2nd pattern
            for(int j = 0; j <= col; j++){
                if (j == 1 || j == col) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }





        // Question - 25
        System.out.println("\n\nQuestion - 25: ");

        for (int i = 1; i <= rows; i++) {
            // for outer space
            for(int space = 0; space < rows - i; space++){
                System.out.print(" ");
            }

            System.out.print("*");
            // for stars and inner space

            String s = " ";
            if (i == 1 || i == rows) {
                s = "*";
            }

            for(int j = 0; j < rows - 2; j++){
                System.out.print(s);
            }
            System.out.println("*");
        }


        


        // Question - 26
        System.out.println("\n\nQuestion - 26");

        for (int i = 1; i <= rows; i++) {
            for(int j = 0; j <= rows - i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();

        // 2nd-method
        for (int i = 1; i <= rows; i++) {
            System.out.println((i + " ").repeat((rows - i) + 1));
        }





        // Question - 27
        System.out.println("\n\nQuestion - 27");

        for (int i = 1; i <= (rows * 2); i++) {

            // for outer space
            int space = 0;
            if (i < rows) {
                space = rows - i;
            }
            else{
                space = i - rows;
            }

            while (space > 0) {
                System.out.print(" ");
                space--;
            }


            // for stars
            int stars = 0;
            if (i < rows) {
                stars = i;
            }
            else{
                stars = (rows * 2) - i;
            }

            while (stars > 0) {
                System.out.print("* ");
                stars--;
            }
            System.out.println();
        }





        // Question - 28
        System.out.println("\n\nQuestion - 28");

        for (int i = rows - 1; i >= 0; i--) {
            
            // for space
            for(int space = 0; space < i * 2; space++){
                System.out.print(" ");
            }

            int val = rows - i;
            int dummyVal = val;
            int size = -val;
            while (size != (val-1)){
                System.out.print(dummyVal + " ");

                size++;
                if (size < 0) {
                    dummyVal--;
                }
                else{
                    dummyVal++;
                }

            }
            System.out.println();
        }



        

        // Question - 29
        System.out.println("\n\nQuestion - 29");

        int n = 2 * rows - 1;  // size of grid

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               
                // for right side
                int right = n - j - 1;

                // for bottom side
                int bottom = n - i - 1;

                int no = Math.min(Math.min(i,bottom), Math.min(j, right));
                System.out.print(rows - no + " ");
            }
            System.out.println();
        }


    



        // Question - 30
        System.out.println("\n\nQuestion - 30");

        for(int i = 1; i <= rows; i++){
            char helper = (char) ((rows - i) + 'A');  // char used for make integer to char

            for (int j = 0; j < i; j++) {
                System.out.print(helper++ + " ");
            }
            System.out.println();
        }





        // Question - 31
        System.out.println("\n\nQuestion - 31");

        char dummyChar = 'a'; // initiater
        boolean toggle = true; // used for togle the characters

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(dummyChar++ + " ");

                if (toggle) {
                    dummyChar -= 32;
                }
                else{
                    dummyChar += 32;
                }

                toggle = !toggle;
            }
            System.out.println();
        }

        


        // Question - 32
        System.out.println("\n\nQuestion - 32");

        for(int i = 1; i <= rows; i++){
            char dummyTempChar = (char)('A' + (rows - i));

            for (int j = 0; j <= rows - i; j++) {
                System.out.print(dummyTempChar-- + " ");
            }
            System.out.println();
        }





        // Question - 33
        System.out.println("\n\nQuestion - 33");

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= (rows * 2); i += 2) {

            for(int j = 1; j <= i/2; j++){
                sb.append(""+j);
                System.out.print(j);
            }

            // for inner space
            for(int innerSpace = 0; innerSpace < (rows *2) - i; innerSpace++){
                System.out.print(" ");
            }
            System.out.println(sb.reverse());

            sb.setLength(0);
        }
        




        // Question - 34
        System.out.println("\n\nQuestion - 34");

        n = 2 * (rows) + 1;  // size of grid

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               
                // for right side
                int right = n - j - 1;

                // for bottom side
                int bottom = n - i - 1;

                int no = Math.min(Math.min(i,bottom), Math.min(j, right));
                System.out.print(no + " ");
            }
            System.out.println();  
        }





        // Question - 35 --> idea from question 17
        System.out.println("\n\nQuestion - 35: ");

        for (int i = (rows * 2) - 1; i > 0; i--) {

            // for space
            int space = (i > rows) ? i - rows : rows - i;

            while (space > 0) {
                System.out.print("  ");
                space--;
            }


            int val = (i > rows) ? (rows * 2) - i : i;

            int dummyVal = val;
            int size = -val;
            while (size != (val-1)){
                System.out.print(dummyVal + " ");

                size++;
                if (size < 0) {
                    dummyVal--;
                }
                else{
                    dummyVal++;
                }

            }
            System.out.println();
        }




        // My Name starts letter - K  --> idea from questin - 24
        System.out.println("\n\n Printing Letter K");
        int name = (rows *2);
        for (int i = 1; i <= name; i++) {

            int col = i <= rows ? i : name - i + 1;
            // 1st pattern
            for(int j = 0; j <= col; j++){
                if (j == 1 || j == col) {
                    System.out.print("*");
                }
            }

            // for space between two patterns
            int outerSpace = (rows - col) * 2;
            while (outerSpace > 0) {
                System.out.print(" ");
                outerSpace--;
            }


            // 2nd pattern
            for(int j = 0; j <= col; j++){
                if (j == 1 || j == col) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Thank You");
    }
}
