.MODEL SMALL
.STACK 100H
.DATA
    MENU DB 10,13, " MENU ",
         DB 10,13, "PRESS 1 FOR ADDITION            " ,
         DB 10,13, "PRESS 2 FOR SUBTRACTION         " ,
         DB 10,13, "PRESS 3 FOR MULTIPLICATION      " ,
         DB 10,13, "PRESS 4 FOR DIVISION(REMAINDER) " ,
         DB 10,13, "EXIT$ " 
         
         
     MSG1 DB 10,13, "ERROR! ENTER A VALID DIGIT CHARACTER::,$"
     MSG2 DB 10,13, "ENTER FIRST DIGIT                   ::,$"
     MSG3 DB 10,13, "ENTER SECOND DIGIT                  ::,$"
     MSG4 DB 10,13, "RESULT OF CALCULATION               ::,$"
     MSG5 DB 10,13, "PRESS ANY KEY TO PROCEED            ::,$"
     OPERAND1 DW ?
     OPERAND2 DW ?
     PLUS_OPERATOR      DB "+$"
     MINUS_OPERATOR     DB "-$"
     MULTIPLY_OPERATOR  DB "*$"
     REMAINDER_OPERATOR DB "%$"
     QUOTIENT_OPERATOR  DB "/$"
     EQUALS_OPERATOR    DB "=$"
     TEMPORARY DB ?
 
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        
        
        
        START:
            MOV DX,OFFSET MSG2
            MOV AH,9
            INT 21H
            
            
            
            
                 
     
           
         
                