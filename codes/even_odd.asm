.MODEL SMALL
.STACK 100H

.DATA
    M1 DB "Input a digit: $"         ; Prompt Message
    M2 DB 0AH, 0DH, "Even$", 0       ; Even Message
    M3 DB 0AH, 0DH, "Odd$", 0        ; Odd Message

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

    ; Display Prompt
    MOV DX, OFFSET M1
    MOV AH, 9
    INT 21h

    ; Read Single Character Input (digit)
    MOV AH, 1
    INT 21h         ; AL has ASCII code of digit

    SUB AL, 30h     ; Convert ASCII to Numeric (e.g., '5' -> 5)
    AND AL, 1       ; Check LSB to determine even/odd

    JZ EVEN         ; If result is zero, it's even

    ; Else it is odd
    MOV DX, OFFSET M3
    MOV AH, 9
    INT 21h
    JMP QUIT

EVEN:
    MOV DX, OFFSET M2
    MOV AH, 9
    INT 21h

QUIT:
    MOV AH, 4Ch
    INT 21h

MAIN ENDP
END MAIN
