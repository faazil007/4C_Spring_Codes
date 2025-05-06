MOV     AX, 123       ; Load the base number
MOV     BX, AX        ; BX = 123 (for second shift)

SHL     AX, 5         ; AX = 123 × 32
SHL     BX, 2         ; BX = 123 × 4

ADD     AX, BX        ; AX = AX + BX = (123×32) + (123×4)
                     ; AX now holds 123 × 36 = 4428
