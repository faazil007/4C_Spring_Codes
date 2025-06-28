;*Matrices are stored as one-dimensional array in the RAM, based on one of the two mehtods
;a. Row Major Order: All elements of first row are stored, followed by the 2nd row, and so on
;b. Column-major Order: # #  # # # # # column #  # # # # #  # # # # # Column # # #

;FORMULEA = BASE ADDRESS+(I + (J-1))*SIZE

.MODEL SMALL
.STACK 100H
.DATA
        ;0   2   4
    ;A DW 10, 20, 30,  ;0
;      DW 40, 50, 60,  ;6
;      DW 70, 80, 90,  ;12
;      
;    B DW 11, 12, 13,
;      DW 21, 22, 23,
;      DW 31, 32, 33,
;      
     A DW 9 DUP(?)
     
     B DW 9 DUP(?)
    
    
    NL DB 10,13, "$"
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        
        LEA BX, A
        MOV DL, 3 ;ROWS
        MOV DH, 3 ;COLUMNS
        MOV AL, 2 ;TYPE
        CALL INP_MATRIX
        
        LEA DX, NL
        MOV AH, 9
        INT 21H 
        
        LEA BX, A
        MOV DL, 3 ;ROWS
        MOV DH, 3 ;COLUMNS
        MOV AL, 2 ;TYPE
        ;CALL DIS_MATRIX
        
        LEA BX, A
        LEA SI, B
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        CALL ADD_MATRIX
        
        LEA BX, A
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        CALL DIS_MATRIX
        
        LEA BX, A
        LEA SI, B
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        CALL SUB_MATRIX
        
        LEA BX, A
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        CALL DIS_MATRIX
        
        LEA BX, A
        LEA SI, B
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        ;CALL MUL_MATRIX
        
        LEA BX, A
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        ;CALL DIS_MATRIX
        
        LEA BX, A
        LEA SI, B
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        ;CALL DIV_MATRIX
        
        LEA BX, A
        MOV DL, 3
        MOV DH, 3
        MOV AL, 2
        ;CALL DIS_MATRIX
        
        QUIT:
            MOV AH, 4CH
            INT 21H
        
    MAIN ENDP
    
    INP_MATRIX PROC
        XOR SI, SI             ; SI = 0 (offset into matrix array)
        
        ;DL = number of rows, DH = number of columns
        MOV CH, 0
        MOV CL, DL             ; CL = outer loop (rows)
        MOV DI,0
    OUTER_LOOP:
        PUSH CX                ; Save outer loop counter
        
        MOV CH, 0
        MOV CL, DH             ; CL = inner loop (columns)
        ;MOV DI, SI             ; DI = offset for this row
        
        
        INNER_LOOP:
            CALL DEC_INP           ; Take user input into AX
            MOV [BX + DI], AX      ; Store at [BX + DI]
            
            PUSH DX
            LEA DX, NL
            MOV AH, 9
            INT 21H
            POP DX
            
            ADD DI, 2              ; Advance by 2 bytes (next word)
            LOOP INNER_LOOP        ; Next column
        
            ; Advance SI to next row start
            ;MOV AX, 0
;            MOV AL, DH             ; AX = number of columns
;            SHL AX, 1              ; AX = AX * 2 (each element = 2 bytes)
;            ADD SI, AX             ; SI += row size in bytes
        
            POP CX
        LOOP OUTER_LOOP        ; Next row
    
        RET
    INP_MATRIX ENDP
        

    
    DIS_MATRIX PROC
        XOR SI, SI             ; SI = 0
    
        ; Outer loop over rows (DL = #rows)
        MOV CH, 0              ; Clear CH
        MOV CL, DL             ; Set CL = row counter
        OUTER_LOOP_2:
            PUSH CX                ; Save row counter
        
            MOV CH, 0              ; Clear CH
            MOV CL, DH             ; Set CL = column counter
            MOV DI, SI             ; DI = starting offset for this row
        
            INNER_LOOP_2:
                MOV AX, [BX + DI]
                CALL DEC_OUT
                
                MOV DL, ','
                MOV AH, 2
                INT 21H
                
                ADD DI, 2              ; Move to next element in row
                LOOP INNER_LOOP_2
            
                ; New line
                PUSH DX
                LEA DX, NL
                MOV AH, 9
                INT 21H
                POP DX
            
                MOV AX, 0      ; clear AX
                MOV AL, DH     ; promote DH (8-bit) to AX (16-bit)
                SHL AX, 1      ; AX = DH * 2 (because each element is 2 bytes)
                ADD SI, AX     ; SI += AX

                POP CX
            LOOP OUTER_LOOP_2

        RET
    DIS_MATRIX ENDP
 
    
    ADD_MATRIX PROC
        MOV AX, 0;displacement for next line
        MOV CH, 0
        MOV CL, DL
        OUTER_LOOP_3:
            PUSH CX
            MOV CL, DH
            MOV DI, AX;next word index 
            INNER_LOOP_3:
                PUSH AX
                MOV AX, BX;address of 'A' matric
                MOV BX, SI
                
                PUSH DX
                MOV DX, [BX+DI]
                MOV BX, AX
                ADD [BX+DI], DX
                POP DX
                
                POP AX
                ADD DI, 2
                LOOP INNER_LOOP_3
                
                PUSH DX
                PUSH AX
                
                ;catch next row
                MOV AX, 0
                MOV AL, DH
                SHL AX, 1
                MOV DX, AX
                POP AX
                ADD AX, DX 
                
                POP DX
                
            POP CX
            LOOP OUTER_LOOP_3
        
        RET
    ADD_MATRIX ENDP
    
    SUB_MATRIX PROC
        MOV AX, 0
        MOV CH, 0
        MOV CL, DL
        OUTER_LOOP_4:
            PUSH CX
            MOV CL, DH
            MOV DI, AX 
            INNER_LOOP_4:
                PUSH AX
                MOV AX, BX
                MOV BX, SI
                
                PUSH DX
                MOV DX, [BX+DI]
                
                MOV BX, AX
                SUB [BX+DI], DX
                POP DX
                
                POP AX
                ADD DI, 2
                LOOP INNER_LOOP_4
                
                PUSH DX
                PUSH AX
                
                MOV AX, 0
                MOV AL, DH
                SHL AX, 1
                MOV DX, AX
                POP AX
                ADD AX, DX 
                
                POP DX
                
            POP CX
            LOOP OUTER_LOOP_4
        
        RET
    SUB_MATRIX ENDP
    
    MUL_MATRIX PROC
        MOV AX, 0
        MOV CH, 0
        MOV CL, DL
        OUTER_LOOP_5:
            PUSH CX
            MOV CL, DH
            MOV DI, AX 
            INNER_LOOP_5:
                PUSH DX;
                PUSH AX
                
                MOV AX, [BX+DI]
                
                MOV DX, BX;
                MOV BX, SI
                
                PUSH DX
                MUL [BX+DI]
                POP DX
                MOV BX, DX
                MOV [BX+DI], AX
                POP AX
                
                POP DX;
                ADD DI, 2
                LOOP INNER_LOOP_5
                
                PUSH DX
                PUSH AX
                
                MOV AX, 0
                MOV AL, DH
                SHL AX, 1
                MOV DX, AX
                POP AX
                ADD AX, DX 
                
                POP DX
                
            POP CX
            LOOP OUTER_LOOP_5
        
        RET
    MUL_MATRIX ENDP
    
    DIV_MATRIX PROC
        MOV AX, 0
        MOV CH, 0
        MOV CL, DL
        OUTER_LOOP_6:
            PUSH CX
            MOV CL, DH
            MOV DI, AX 
            INNER_LOOP_6:
                PUSH DX;
                
                PUSH AX
                MOV AX, [BX+DI]
                
                MOV DX, BX;
                MOV BX, SI
                
                PUSH DX
                DIV [BX+DI]
                POP DX
                MOV BX, DX
                MOV [BX+DI], AX
                POP AX
                
                POP DX;
                ADD DI, 2
                LOOP INNER_LOOP_6
                
                PUSH DX
                PUSH AX
                
                MOV AX, 0
                MOV AL, DH
                SHL AX, 1
                MOV DX, AX
                POP AX
                ADD AX, DX 
                
                POP DX
                
            POP CX
            LOOP OUTER_LOOP_6
        
        RET
    DIV_MATRIX ENDP
    
    DEC_INP PROC
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 0
        MOV CX, 10
        
        AGAIN1:
            CALL CHAR_INP
            
            CMP AL, '0'
            JB DONE_INP
            
            CMP AL, '9'
            JA DONE_INP
            
            SUB AL, '0'
            
            MOV AH, 0
            
            PUSH AX
            
            MOV AX, BX
            
            MUL CX
            
            POP BX
            
            ADD BX, AX
            
            JMP AGAIN1
            
        DONE_INP:
            MOV AX, BX
            
        POP DX
        POP CX
        POP BX
            
        RET
    DEC_INP ENDP
    
    DEC_OUT PROC
        PUSH AX
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 10
        MOV CX, 0
        AGAIN2:        
            MOV DX, 0
            
            DIV BX
            
            PUSH DX
            
            INC CX
            
            CMP AX, 0
        
            JNZ AGAIN2
            
        DISPLAY:
            POP DX
            
            ADD DX, '0'
            
            CALL CHAR_OUT
            
            LOOP DISPLAY 
        
        POP DX
        POP CX
        POP BX
        POP AX
        RET
    DEC_OUT ENDP
    
    CHAR_INP PROC
        MOV AH, 1
        INT 21H
        
        RET
    CHAR_INP ENDP
    
    CHAR_OUT PROC
        MOV AH, 2
        INT 21H
        
        RET
    CHAR_OUT ENDP