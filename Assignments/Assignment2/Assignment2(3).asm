.model small
.stack 100h

.data
array   DD 10, 20, 30, 40   ; 4 elements, 32-bit integers
count   DW 4                 ; Number of elements in the array

.code
start:
    MOV     AX, @data
    MOV     DS, AX

    LEA     SI, array        ; SI points to the start of the array
    MOV     CX, count        ; Set the loop counter for number of elements
    MOV     DX, [SI + 12]    ; Load last element (array[3]) into DX (temporary storage)

rotate_loop:
    MOV     AX, [SI + 8]     ; Load array[2] into AX
    MOV     [SI + 12], AX    ; Store AX into array[3] (shift array[2] to array[3])

    MOV     AX, [SI + 4]     ; Load array[1] into AX
    MOV     [SI + 8], AX     ; Store AX into array[2] (shift array[1] to array[2])

    MOV     AX, [SI]         ; Load array[0] into AX
    MOV     [SI + 4], AX     ; Store AX into array[1] (shift array[0] to array[1])

    MOV     [SI], DX         ; Store the last element (from DX) to array[0]

    LOOP rotate_loop         ; Repeat the process for the number of elements

    ; Exit program
    MOV     AH, 4Ch
    INT     21h

end start
