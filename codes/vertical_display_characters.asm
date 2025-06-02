TITLE Read and Display Initials Vertically

.stack

.data
    Initial1    DB ?
    Initial2    DB ?
    Initial3    DB ?

    PromptMsg   DB "ENTER THREE INITIALS: ", '$'
    NewLine     DB 0Ah, 0Dh, '$'

.code
main proc
    MOV AX, @data
    MOV DS, AX

    ; Show prompt
    MOV DX, offset PromptMsg
    MOV AH, 9
    INT 21h

    ; Read 1st Initial
    MOV AH, 1
    INT 21h
    MOV Initial1, AL

    ; Read 2nd Initial
    MOV AH, 1
    INT 21h
    MOV Initial2, AL

    ; Read 3rd Initial
    MOV AH, 1
    INT 21h
    MOV Initial3, AL
    
    
    ; New line
    MOV DX, offset NewLine
    MOV AH, 9
    INT 21h


    ; === Display Initial 1 ===
    MOV DL, Initial1
    MOV AH, 2
    INT 21h

    ; New line
    MOV DX, offset NewLine
    MOV AH, 9
    INT 21h

    ; === Display Initial 2 ===
    MOV DL, Initial2
    MOV AH, 2
    INT 21h

    ; New line
    MOV DX, offset NewLine
    MOV AH, 9
    INT 21h

    ; === Display Initial 3 ===
    MOV DL, Initial3
    MOV AH, 2
    INT 21h

    ; New line (optional)
    MOV DX, offset NewLine
    MOV AH, 9
    INT 21h            
    
    
    
    
    
    
    
   

    ; Exit to DOS
    MOV AH, 4Ch
    INT 21h
main endp

end main
