.MODEL SMALL
.STACK 100H

.DATA
    message1 DB 0AH, 0DH, " Enter an alphabet: $"
    message2 DB 0AH, 0DH, " Capital to Small: $"
    message3 DB 0AH, 0DH, " Small to Capital: $"
    message4 DB 0AH, 0DH, " Sorry, reenter the letter: $"
    message5 DB 0AH, 0DH, " Do you want to continue again (Y/N): $"
    ch DB ?

.CODE
START:
    MOV AX, @DATA
    MOV DS, AX

AGAIN:
    ; Display message1
    LEA DX, message1
    MOV AH, 9
    INT 21H

    ; Read a character from user
    MOV AH, 1
    INT 21H
    MOV ch, AL          ; Store character in 'ch'

    ; Check if input is between 'A' and 'Z'
    CMP ch, 'A'
    JB ERROR_MSG        ; If below 'A', invalid

    CMP ch, 'Z'
    JBE CAPITAL_INPUT   ; If A <= ch <= Z

    ; Check if input is between 'a' and 'z'
    CMP ch, 'a'
    JB ERROR_MSG        ; If below 'a', invalid

    CMP ch, 'z'
    JA ERROR_MSG        ; If above 'z', invalid

    ; Convert small to capital
    AND ch, 11011111B       ; Clear 5th bit to get capital
    LEA DX, message3
    MOV AH, 9
    INT 21H

    MOV DL, ch
    MOV AH, 2
    INT 21H
    JMP CHOICE

CAPITAL_INPUT:
    ; Convert capital to small
    OR ch, 00100000B        ; Set 5th bit to get small
    LEA DX, message2
    MOV AH, 9
    INT 21H

    MOV DL, ch
    MOV AH, 2
    INT 21H
    JMP CHOICE

ERROR_MSG:
    LEA DX, message4
    MOV AH, 9
    INT 21H
    JMP CHOICE

CHOICE:
    ; Ask to continue
    LEA DX, message5
    MOV AH, 9
    INT 21H

    MOV AH, 1
    INT 21H
    CMP AL, 'Y'
    JE AGAIN           ; If Y/y, repeat
    CMP AL, 'y'
    JE AGAIN

    ; If N/n or anything else, quit
    CMP AL, 'N'
    JE QUIT
    CMP AL, 'n'
    JE QUIT

    ; If invalid input, just quit anyway
    JMP QUIT

QUIT:
    MOV AH, 4CH
    INT 21H

END START
