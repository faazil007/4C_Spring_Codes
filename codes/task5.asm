TITLE Read Two Digits and Show Their Sum

.stack

.data
    FirstDigit  DB ?
    SecondDigit DB ?
    Sum         DB ?

    MsgQ        DB "?", '$'
    MsgResult   DB 0Ah, 0Dh, "THE SUM OF ", '$'
    MsgAnd      DB " AND ", '$'
    MsgIs       DB " IS ", '$'

.code
main proc
    MOV AX, @data
    MOV DS, AX

    ; Show Prompt ?
    MOV DX, offset MsgQ
    MOV AH, 9
    INT 21h

    ; Read First Digit
    MOV AH, 1
    INT 21h
    MOV FirstDigit, AL
    SUB AL, '0'
    MOV BL, AL

    ; Read Second Digit
    MOV AH, 1
    INT 21h
    MOV SecondDigit, AL
    SUB AL, '0'
    ADD BL, AL
    MOV Sum, BL

    ; Print Result
    MOV DX, offset MsgResult
    MOV AH, 9
    INT 21h

    ; Print First Digit
    MOV AL, FirstDigit
    MOV DL, AL
    MOV AH, 2
    INT 21h

    ; Print " AND "
    MOV DX, offset MsgAnd
    MOV AH, 9
    INT 21h

    ; Print Second Digit
    MOV AL, SecondDigit
    MOV DL, AL
    MOV AH, 2
    INT 21h

    ; Print " IS "
    MOV DX, offset MsgIs
    MOV AH, 9
    INT 21h

    ; Print Sum (Only if result is less than 10)
    MOV AL, Sum
    ADD AL, '0'     ; Convert back to ASCII
    MOV DL, AL
    MOV AH, 2
    INT 21h

    ; Exit
    MOV AH, 4Ch
    INT 21h
main endp

end main
