.stack
.data  

    V1 DB 7
    V2 DB 10110B
    V3 DW -22
    V4 DW 0ABCDH
    V5 DW 04213H 
    
.code
   MAIN PROC
      
      MOV AX,@DATA
      MOV DS,AX 
     ;--------------------------
     
     ; <Program Secific Area>
     
     MOV AL,40      ;This 40 will be stored in hex, equivalent of 40 in hex is 28
     add AL,-40     ;It will add -40 into 40 AL will become zero.
     sub AL,5       ;It will subtract 5 from 0 and then it will store the 2s Compliment of 5 in the AL register which is FB
      
      
                    ; Carry flag is set because of Borrowing or carrying a bit from outer..
                    ; Sign flag is set because of negative entry of bit
                    ; Auxiliary flag is set because a bit is carried through middle nibble.
    
    
    
     
    
    
      MOV AH,4CH
      INT 21H     
      ;--------------------------
    
      MAIN ENDP
   END MAIN
   
    