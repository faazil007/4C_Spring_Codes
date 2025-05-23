.MODEL SMALL
.STACK 100H
;-------------------------------------------------------------------------
.DATA
    ;--------------------------------------------------------------------
     MENU1 DB 0DH,0AH,  " -------CALCULATOR-SELECTION--------- ",
           DB 0DH,0AH,   "BINARY CALCULATOR      (b or B)           ::",
           DB 0DH,0AH,   "OCTAL CALCULATOR       (o or O)           ::",
           DB 0DH,0AH,   "DECIMAL CALCULATOR     (d or D)           ::",
           DB 0DH,0AH,   "HEXADECIMAL CALCULATOR (h or H)           ::",
           DB 0DH,0AH,   "EXIT                   (e or E)           ::$"
    ;--------------------------------------------------------------------       
         
     MENU2 DB 0DH,0AH,  " -------OPERATIONS--------- ",
           DB 0DH,0AH,   "PRESS 1 FOR ADDITION           ::",
           DB 0DH,0AH,   "PRESS 2 FOR SUBTRACTION        ::",
           DB 0DH,0AH,   "PRESS 3 FOR MULTIPLICATION     ::",
           DB 0DH,0AH,   "PRESS 4 FOR DIVISION(REMAINDER)::",
           DB 0DH,0AH,   "PRESS 5 FOR DIVISION(QUOTIENT) ::",
           DB 0DH,0AH,   "PRESS 6 TO JUMP TO MAIN MENU$ " 
    ;--------------------------------------------------------------------
     
     MSG1 DB 10,13, "ENTER FIRST DIGIT ::,$"
     MSG2 DB 10,13, "ENTER SECOND DIGIT::,$"
     MSG3 DB 10,13, "ERROR! ENTER A VALID DIGIT CHARACTER::,$"
     MSG4 DB 10,13, "RESULT OF CALCULATION::,$"
     MSG5 DB 10,13, "PRESS ANY KEY TO PROCEED!!!,$"
     MSG6 DB 10,13, "PLEASE ENTER A VALID CHARACTER TO PROCEED!!!,$"
     
    ;-------------------------------------------------------------------- 
     
     NEWLINE DB 0Dh, 0Ah, '$'
     PLUS_OPERATOR      DB "+$"
     MINUS_OPERATOR     DB "-$"
     MULTIPLY_OPERATOR  DB "*$"
     REMAINDER_OPERATOR DB "%$"
     QUOTIENT_OPERATOR  DB "/$"
     EQUALS_OPERATOR    DB "=$"
    ;-------------------------------------------------------------------- 
     TEMPORARY DB ?
     OPERAND1 DW ?
     OPERAND2 DW ?
;--------------------------------------------------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        
        
        
        START:
            MOV DX, OFFSET MENU1
            CALL STRING_DISPLAY
            
            MOV DX, OFFSET NEWLINE
            CALL STRING_DISPLAY
           ;-----------------------------------------------------------------;
           ;-----------------------------------------------------------------;
           ;-----------------------------------------------------------------;
            START2:
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'b'
                JE BINARY
                
                CMP BL,'B'
                JE BINARY
            
                CMP BL,'o'
                JE OCTAL
                
                CMP BL,'O'
                JE OCTAL
                
                CMP BL,'d'
                JE DECIMAL
                
                CMP BL,'D'
                JE DECIMAL
                
                CMP BL,'h'
                JE HEXADECIMAL
                
                CMP BL,'H'
                JE HEXADECIMAL
            
                CMP BL,'e'
                JE QUIT
                
                CMP BL,'E'
                JE QUIT
            
                JNE ERROR2
           ;-----------------------------------------------------------------; 
           ;-----------------------------------------------------------------; 
           ;-----------------------------------------------------------------; 
            DECIMAL:
                MOV DX, OFFSET MENU2
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'1'
                JE DECIMAL_ADDITION
            
                CMP BL,'2'
                JE DECIMAL_SUBTRACTION
            
                CMP BL,'3'
                JE DECIMAL_MULTIPLICATION
            
                CMP BL,'4'
                JE DECIMAL_CHECKING_REMAINDER
            
                CMP BL,'5'
                JE DECIMAL_CHECKING_QUOTIENT
            
                CMP BL,'6'
                JE START
          ;------------------------------------------------------------------   
            DECIMAL_ADDITION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND2, AX 
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                                
                MOV AX,OPERAND1
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET PLUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                ADD BX,OPERAND2
                
                MOV AX,BX
                CALL DECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
          ;--------------------------------------------------------------------      
            DECIMAL_SUBTRACTION:
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET MINUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                SUB BX,OPERAND2
                
                MOV AX,BX
                CALL DECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
         ;-----------------------------------------------------------------------
            DECIMAL_MULTIPLICATION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND2, AX                
             
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET MULTIPLY_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, OPERAND1
                MUL OPERAND2
                CALL DECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
         ;-------------------------------------------------------------------   
            DECIMAL_CHECKING_REMAINDER:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET REMAINDER_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                MOV AX, 0
                MOV AX, DX 
                
                CALL DECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
          ;-------------------------------------------------------------------      
             DECIMAL_CHECKING_QUOTIENT:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL DECIMAL_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET QUOTIENT_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL DECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY   
                
            
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                    
                CALL DECIMAL_OUTPUT
                    
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
          ;--------------------------------------------------------------------;
          ;--------------------------------------------------------------------;      
          ;--------------------------------------------------------------------;
             BINARY:
                MOV DX, OFFSET MENU2
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'1'
                JE BINARY_ADDITION
            
                CMP BL,'2'
                JE BINARY_SUBTRACTION
            
                CMP BL,'3'
                JE BINARY_MULTIPLICATION
            
                CMP BL,'4'
                JE BINARY_CHECKING_REMAINDER
            
                CMP BL,'5'
                JE BINARY_CHECKING_QUOTIENT
            
                CMP BL,'6'
                JE START
            
                JNE ERROR
             
                BINARY_ADDITION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX 
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET PLUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                ADD BX,OPERAND2
                
                MOV AX,BX
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP BINARY
          ;--------------------------------------------------------------------      
            BINARY_SUBTRACTION:
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET MINUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                SUB BX,OPERAND2
                
                MOV AX,BX
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP BINARY
         ;-----------------------------------------------------------------------
            BINARY_MULTIPLICATION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
             
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET MULTIPLY_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, OPERAND1
                MUL OPERAND2
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP BINARY
         ;-------------------------------------------------------------------   
            BINARY_CHECKING_REMAINDER:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET REMAINDER_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                MOV AX, 0
                MOV AX, DX 
                
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP BINARY
          ;-------------------------------------------------------------------      
             BINARY_CHECKING_QUOTIENT:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET QUOTIENT_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY   
                
            
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                    
                CALL BINARY_OUTPUT
                    
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP BINARY
                
          ;--------------------------------------------------------------------;
          ;--------------------------------------------------------------------;      
          ;--------------------------------------------------------------------;
             OCTAL:
                MOV DX, OFFSET MENU2
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'1'
                JE OCTAL_ADDITION
            
                CMP BL,'2'
                JE OCTAL_SUBTRACTION
            
                CMP BL,'3'
                JE OCTAL_MULTIPLICATION
            
                CMP BL,'4'
                JE OCTAL_CHECKING_REMAINDER
            
                CMP BL,'5'
                JE OCTAL_CHECKING_QUOTIENT
            
                CMP BL,'6'
                JE START
            
                JNE ERROR
         ;----------------------------------------------------------------    
             OCTAL_ADDITION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND2, AX 
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                                
                MOV AX,OPERAND1
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET PLUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                ADD BX,OPERAND2
                
                MOV AX,BX
                CALL OCTAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP OCTAL
         ;--------------------------------------------------------------------      
            OCTAL_SUBTRACTION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET MINUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                SUB BX,OPERAND2
                
                MOV AX,BX
                CALL OCTAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP OCTAL
         ;-----------------------------------------------------------------------
            OCTAL_MULTIPLICATION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND2, AX                
             
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET MULTIPLY_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, OPERAND1
                MUL OPERAND2
                CALL OCTAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP OCTAL
         ;-------------------------------------------------------------------   
            OCTAL_CHECKING_REMAINDER:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET REMAINDER_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                MOV AX, 0
                MOV AX, DX 
                
                CALL OCTAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP OCTAL
          ;-------------------------------------------------------------------      
            OCTAL_CHECKING_QUOTIENT:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL OCTAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET QUOTIENT_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL OCTAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY   
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                    
                CALL OCTAL_OUTPUT
                    
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP OCTAL
          ;--------------------------------------------------------------------;
          ;--------------------------------------------------------------------;      
          ;--------------------------------------------------------------------;
          
             HEXADECIMAL:
                MOV DX, OFFSET MENU2
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'1'
                JE HEXADECIMAL_ADDITION
            
                CMP BL,'2'
                JE HEXADECIMAL_SUBTRACTION
            
                CMP BL,'3'
                JE HEXADECIMAL_MULTIPLICATION
            
                CMP BL,'4'
                JE HEXADECIMAL_CHECKING_REMAINDER
            
                CMP BL,'5'
                JE HEXADECIMAL_CHECKING_QUOTIENT
            
                CMP BL,'6'
                JE START
            
                JNE ERROR
         ;----------------------------------------------------------------    
             HEXADECIMAL_ADDITION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND2, AX 
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                                
                MOV AX,OPERAND1
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET PLUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                ADD BX,OPERAND2
                
                MOV AX,BX
                CALL HEXADECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP HEXADECIMAL
         ;--------------------------------------------------------------------      
            HEXADECIMAL_SUBTRACTION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET MINUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                SUB BX,OPERAND2
                
                MOV AX,BX
                CALL HEXADECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP HEXADECIMAL
         ;-----------------------------------------------------------------------
            HEXADECIMAL_MULTIPLICATION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET MULTIPLY_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, OPERAND1
                MUL OPERAND2
                CALL HEXADECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP HEXADECIMAL
         ;-------------------------------------------------------------------   
            HEXADECIMAL_CHECKING_REMAINDER:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET REMAINDER_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                MOV AX, 0
                MOV AX, DX 
                
                CALL HEXADECIMAL_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP HEXADECIMAL
          ;-------------------------------------------------------------------      
            HEXADECIMAL_CHECKING_QUOTIENT:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL HEXADECIMAL_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET QUOTIENT_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL HEXADECIMAL_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY   
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                    
                CALL HEXADECIMAL_OUTPUT
                    
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP HEXADECIMAL
          ;--------------------------------------------------------------------;
          ;--------------------------------------------------------------------;      
          ;--------------------------------------------------------------------;
   
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
          ;------------------------------------------------------------------------   
             ERROR:
                MOV DX, OFFSET MSG3
                CALL STRING_DISPLAY
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP DECIMAL
             
             ERROR2:
                MOV DX, OFFSET MSG6
                CALL STRING_DISPLAY
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
                   
                
             JMP QUIT                
             
             QUIT:
                MOV AH,4CH
                INT 21H    
                   
    MAIN ENDP

;---------------------------------------------------------
; *************** ALL DECIMAL PROCEDURES *****************
;---------------------------------------------------------


;--------------------------------    
; 1st Proc    
;--------------------------------    
    CHARACTER_INPUT PROC
        MOV AH,1
        INT 21H
        MOV TEMPORARY,AL
        
        RET
      
    CHARACTER_INPUT ENDP
;--------------------------------    

;--------------------------------
; 2nd Proc
;--------------------------------    
    CHARACTER_OUTPUT PROC
        MOV AH,2
        INT 21H
        
        RET
        
    CHARACTER_OUTPUT ENDP    

;--------------------------------
; 3rd Proc
;--------------------------------
    STRING_DISPLAY PROC
        MOV AH,9
        INT 21H
        
        RET
    STRING_DISPLAY ENDP
       
;--------------------------------
; 4th Proc
;--------------------------------
    DECIMAL_INPUT PROC
        MOV BX,0
        MOV CX,10
        
        INPUT_DEC1:
            CALL CHARACTER_INPUT
            MOV AL,TEMPORARY
            
            CMP AL,'0'
            JB INPUT_DEC2
            
            CMP AL,'9'
            JA INPUT_DEC2
            
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX
            ADD BX,AX
            JMP INPUT_DEC1
            
        
        
        INPUT_DEC2:
            MOV AX,BX
            
        
        RET
        
    DECIMAL_INPUT ENDP            
    
;--------------------------------
; 5th Proc
;--------------------------------
    DECIMAL_OUTPUT PROC
        MOV BX,10
        MOV CX,0   
        
        OUTPUT_DEC1:
            MOV DX,0
            DIV BX
            PUSH DX
            INC CX
            CMP AX,0
            JNZ OUTPUT_DEC1
        
            
        DISPLAY_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY_DIGITS
        
        RET
        
     DECIMAL_OUTPUT ENDP
    
;------------------------------------------------------------------------    
;---------------------------------------------------------
; *************** ALL BINARY PROCEDURES *****************
;---------------------------------------------------------

;--------------------------------
; 1ST Proc
;--------------------------------
    BINARY_INPUT PROC
        MOV BX,0
        MOV CX,2
        
        INPUT_BIN1:
            CALL CHARACTER_INPUT
            MOV AL,TEMPORARY
            
            CMP AL,'0'
            JB INPUT_BIN2
            
            CMP AL,'1'
            JA INPUT_BIN2
            
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX
            ADD BX,AX
            JMP INPUT_BIN1
            
        
        
        INPUT_BIN2:
            MOV AX,BX
            
        
        RET
        
    BINARY_INPUT ENDP            
    
;--------------------------------
; 2ND Proc
;--------------------------------
    BINARY_OUTPUT PROC
        MOV BX,2
        MOV CX,0   
        
        OUTPUT_BIN1:
            MOV DX,0
            DIV BX
            PUSH DX
            INC CX
            CMP AX,0
            JNZ OUTPUT_BIN1
        
            
        DISPLAY2_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY2_DIGITS
        
        RET
        
     BINARY_OUTPUT ENDP
    
;------------------------------------------------------------------------              
        
;---------------------------------------------------------
; *************** ALL OCTAL PROCEDURES *****************
;---------------------------------------------------------

;--------------------------------
; 1ST Proc
;--------------------------------
     OCTAL_INPUT PROC
            MOV BX,0
            MOV CX,8                  
        
        INPUT_OCT1:
            CALL CHARACTER_INPUT
            MOV AL,TEMPORARY
        
            CMP AL,'0'
            JB INPUT_OCT2
        
            CMP AL,'7'                
            JA INPUT_OCT2
        
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX
            ADD BX,AX
            JMP INPUT_OCT1
        
        INPUT_OCT2:
            MOV AX,BX
        
        RET
        
     OCTAL_INPUT ENDP            


;--------------------------------
; 2ND Proc
;--------------------------------
     OCTAL_OUTPUT PROC
            MOV BX,8                  
            MOV CX,0   
    
        OUTPUT_OCT1:
            MOV DX,0
            DIV BX
            PUSH DX
            INC CX
            CMP AX,0
            JNZ OUTPUT_OCT1

        DISPLAY_OCT_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY_OCT_DIGITS

        RET
        
     OCTAL_OUTPUT ENDP
;----------------------------------------------------------------------
   
;---------------------------------------------------------
; *************** ALL HEXADECIMAL PROCEDURES *****************
;---------------------------------------------------------

;---------------------------------------------------------
; 1ST PROC
;---------------------------------------------------------    
    
    
     HEXADECIMAL_INPUT PROC
        MOV BX,0
        MOV CX,16

     INPUT_HEX1:
        CALL CHARACTER_INPUT
        MOV AL,TEMPORARY
        
        ; Check for 0-9
        CMP AL,'0'
        JB INPUT_HEX2
        
        CMP AL,'9'
        JBE IS_DECIMAL
        
        ; Check for A-F
        CMP AL,'A'
        JB INPUT_HEX2
        
        CMP AL,'F'
        JA INPUT_HEX2
        
        ; Convert A-F to 10-15
        SUB AL,'A'
        ADD AL,10
        JMP CONTINUE_INPUT

     IS_DECIMAL:
        SUB AL,'0'

     CONTINUE_INPUT:
        MOV AH,0
        PUSH AX
        MOV AX,BX
        MUL CX
        POP BX
        ADD BX,AX
        JMP INPUT_HEX1

     INPUT_HEX2:
        MOV AX,BX

        RET

     HEXADECIMAL_INPUT ENDP


;--------------------------------
; 2ND Proc
;--------------------------------
     HEXADECIMAL_OUTPUT PROC
        MOV BX,16
        MOV CX,0   

     OUTPUT_HEX1:
        MOV DX,0
        DIV BX
        PUSH DX
        INC CX
        CMP AX,0
        JNZ OUTPUT_HEX1

     DISPLAY_HEX_DIGITS:
        POP DX
        CMP DX,9
        JBE IS_NUMERIC
        ADD DX,'A'-10
        JMP PRINT_HEX

     IS_NUMERIC:
        ADD DX,'0'

     PRINT_HEX:
        CALL CHARACTER_OUTPUT
        LOOP DISPLAY_HEX_DIGITS

        RET

     HEXADECIMAL_OUTPUT ENDP
   ;-----------------------------------------------------------------------------