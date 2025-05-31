.MODEL SMALL
.STACK 100H
.DATA
    NEWLINE DB 13, 10, '$'    ; Carriage Return + Line Feed for new line

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

   
    MOV AX, 0      ; Outer loop counter
    MOV BX, 0      ; Total inner iterations

    MOV CX, 5     ; Outer loop will run 15 times
OUTER:
    INC AX         ; AX = AX + 1 (outer count)

    PUSH CX        ; Save outer loop count
    MOV CX,2     ; Inner loop counter
INNER:
    INC BX         ; BX = BX + 1

    ; --- Print '*' character ---
    MOV DL, '*'    ; Character to print
    MOV AH, 02H    ; DOS print function
    INT 21H

    LOOP INNER     ; Loop inner 10 times

    ; --- Print New Line after inner loop ---
    LEA DX, NEWLINE
    MOV AH, 09H
    INT 21H

    POP CX         ; Restore outer loop counter
    LOOP OUTER     ; Loop outer 15 times

    ; --- Exit ---
    MOV AH, 4CH
    INT 21H

MAIN ENDP
END MAIN
