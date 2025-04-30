
; Conversion of capital to small and vice versa using Bitwise Operations
.MODEL SMALL
.STACK 100H

.DATA
    M1  DB 0AH,0DH, "Enter a Character: $"
    M2  DB 0AH,0DH, "You've Entered a Wrong Character, Validate and Re-Enter$"
    M3  DB 0AH,0DH, "Your Converted Character is: $"
    M4  DB 0AH,0DH, "Do you want to convert another character? (Y/N): $"
    CHH DB ?
    ANS DB ?

.CODE
START:
    MOV AX, @DATA
    MOV DS, AX

MAIN_LOOP:

AGAIN:
    ; Show prompt message
    MOV DX, OFFSET M1
    MOV AH, 9
    INT 21H

    ; Take input character
    MOV AH, 1
    INT 21H
    MOV CHH, AL

    ; Check if it's capital letter
    CMP AL, 'A'
    JAE CHECK_UPPER
    JMP CHECK_LOWER

CHECK_UPPER:
    CMP AL, 'Z'
    JBE TO_LOWER
    JMP ERROR

CHECK_LOWER:
    CMP AL, 'a'
    JAE IS_SMALL
    JMP ERROR

IS_SMALL:
    CMP AL, 'z'
    JBE TO_UPPER
    JMP ERROR

TO_LOWER:
    OR CHH, 00100000B   ; Convert to small
    JMP DISPLAY

TO_UPPER:
    AND CHH, 11011111B  ; Convert to capital
    JMP DISPLAY

DISPLAY:
    MOV DX, OFFSET M3
    MOV AH, 9
    INT 21H

    MOV DL, CHH
    MOV AH, 2
    INT 21H

    ; Ask if user wants to repeat
    MOV DX, OFFSET M4
    MOV AH, 9
    INT 21H

    MOV AH, 1
    INT 21H
    MOV ANS, AL

    CMP AL, 'Y'
    JE MAIN_LOOP

    CMP AL, 'y'
    JE MAIN_LOOP

    CMP AL, 'N'
    JE QUIT

    CMP AL, 'n'
    JE QUIT

    JMP MAIN_LOOP   ; Default to repeat if invalid answer

ERROR:
    MOV DX, OFFSET M2
    MOV AH, 9
    INT 21H
    JMP AGAIN

QUIT:
    MOV AH, 4CH
    INT 21H

END START
