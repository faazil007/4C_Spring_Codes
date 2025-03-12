
# **Registers**

Their are 4 General purpose registers used in 8086 Processor.
1. AX (Accumulator Register) → Used for Arithmetic and I/O operations.
2. BX(Base Register) → Used for Offset Addressing.
3. CX(Count Register) → Used for loop operations and Shift/rotate instructions(16_bit).
4. DX(Data Register) → Used for multiply or divide instructions and I/O ports(16_bit).

On the other hand their are also 4 Segmented registers.
1. CS(Code Segment Register) 
2. DS(Data Segment Register)
3. SS(Stack Segment Register) 
 These registers keep the starting addresses of responding segment of currently executing program.

# **Addresses**

There are two types of Addresses Logical and Physical.
1. Logical registers comprises of Segment address which is of 16 bit and offset address which is also of 16 bit. It is used for defining a specific block of memory. 8086 processor divides the processor memory to segments like code segment, data segment, stack segment.
2. Offset addresses are also of 16 bits, it points a specific location inside a segment. It means segment address tells a base location and offset address gives the position of exact data inside the segment. 


# Starting of Formal Instructions in Assembly Language(@ Data Transfer Instructions)

Syntax :   MOV  < Destination>,<Source>
Purpose: Copies contents of source operand into destination operands.
Rules:      
1. Source operand can be a register / Immediate(Constant)/ Memory reference(variable).However destination operands must be either a register or memory reference.
2. Both operands must be of the same / Compatible size (i.e., type).
3. Both operands cannot be memory references.
4. If destination operand is a segment register then source operand must be AX register
5. IP can't be the destination register.

 Examples: 
 1. MOV CX, DX; (This is true according to rules because both operands are registers and of same size).
 2. MOV BL, 'A'; (This is also valid, because ascii code of A will be stored in BL register).
 3. MOV X,Y; (Invalid because both operands cannot be variables).
 4. MOV 0ABCh,123h; (Invalid source and destination both cannot be constant).
 5. MOV CH, 507;(Invalid source operand is greater than CH register in size).
 6. MOV DX,"AB";(it is valid because AB is a word which is of 16 bits and DX is also of 16 bits).
 7. MOV X,BX; (it is valid because x can be a word defined above).
 8. MOV DS,0ABCDh;(because source register must be an AX register)
 9. MOV IP,AX;(It is invalid because IP register can't be a destination operand)