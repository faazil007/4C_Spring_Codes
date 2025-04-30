Title 
 ; A Code to Simply read a character 
 ; and then display it on next line

.stack  
;-----------------------------




;-----------------------------


.data        
;-----------------------------

; <Global Variable Declare>

MyByte DB ?

Message DB "Enter the Character :: ", '$'
Message2 DB "You entered a character : ", '$'



;----------------------------------


.code
    main proc
        MOV AX, @data
        MOV DS, AX
        
        MOV DX,offset Message
        MOV AH,9
        INT 21h
        
        
        MOV Ah,1
        INT 21h
        MOV MyByte , AL   
        
        
        
        
        
        ADD Mybyte,32
        MOV DL, Mybyte
        
        MOV AH, 2
                      
        Int 21h   
        
         MOV AH, 4ch            ; Return control back to OS
        
        Int 21h
    
    main endp

end main                             