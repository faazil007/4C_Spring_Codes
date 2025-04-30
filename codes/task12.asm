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
      
      
      ;ADD AL,BX    (SIZE DIFFERENCE)
     ;ADD X,Y      (BOTH DESTINATION ANS SOURCE CANNOT BE) 
     ;ADD DS,AX    (DS CANNOT BE CHANGED)
     ;SUB IP,003H  (IP CANNOT BE CHANGED)
     ;SUB V1,CX    (SIZE MISMATCHED)
      INC BL
      DEC CH
     
     
      MOV AL,V1
      ADD AL,V2
      MOV BX,V3
      ADD BX,22
      MOV CX,V4
      ADD CX,V5
      NEG AL
    
    
    
     
    
    
      MOV AH,4CH
      INT 21H
    
      MAIN ENDP
   END MAIN
   
    