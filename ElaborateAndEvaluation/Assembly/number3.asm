section .data
    fmt_string db "%s ", 0
    new_line db 0x0A, 0

section .bss

section .text
    global main
    extern printf, malloc, free, strcmp

; Define Node structure
struc Node
    .data resd 1
    .next resd 1
    .prev resd 1
endstruc

main:
    ; Set up stack frame
    push ebp
    mov ebp, esp

    ; Initialize head and tail pointers to NULL
    xor eax, eax
    mov [head], eax
    mov [tail], eax

    ; Car names data
    section .data
cars:
    car1 db "BMW", 0
    car2 db "Lexus", 0
    car3 db "Porsche", 0
    car4 db "Honda", 0
    car5 db "Audi", 0
    car6 db "Hyundai", 0
    car7 db "Toyota", 0
    car8 db "Mercedes-Benz", 0
    car9 db "Subaru", 0

car_list dd car1, car2, car3, car4, car5, car6, car7, car8, car9
car_count equ 9

    ; Begin appending nodes
    mov ecx, 0  ; Counter

append_loop:
    cmp ecx, car_count
    jge append_done

    ; Allocate memory for new Node
    push dword Node_size
    call malloc
    add esp, 4
    mov esi, eax  ; esi = new node

    ; Set node data
    mov ebx, [car_list + ecx*4]
    mov [esi + Node.data], ebx

    ; Set next and prev to NULL
    xor eax, eax
    mov [esi + Node.next], eax
    mov [esi + Node.prev], eax

    ; Append node to list
    cmp dword [head], 0
    jne not_first_node
    ; First node
    mov [head], esi
    mov [tail], esi
    jmp append_continue

not_first_node:
    mov edi, [tail]
    mov [edi + Node.next], esi
    mov [esi + Node.prev], edi
    mov [tail], esi

append_continue:
    inc ecx
    jmp append_loop

append_done:

    ; Print list from head to tail
    mov esi, [head]

print_loop:
    cmp esi, 0
    je print_done
    push dword [esi + Node.data]
    push fmt_string
    call printf
    add esp, 8
    mov esi, [esi + Node.next]
    jmp print_loop

print_done:
    ; Print newline
    push new_line
    call printf
    add esp, 4

    ; Clean up stack frame
    mov esp, ebp
    pop ebp
    ret