MOV     BX, AX        ; Save original signed number
SAR     AX, 15        ; Step 1: Sign mask in AX (0 or FFFFh)
XOR     BX, AX        ; Step 2: BX = BX XOR sign
ADD     BX, AX        ; Step 3: BX = BX + sign
                     ; Result: BX = ABS(Original AX)
