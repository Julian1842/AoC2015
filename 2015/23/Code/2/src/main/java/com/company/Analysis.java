package com.company;

import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public static List<Thunk> getInstructions(List<String> lines, Register a, Register b, Register instructionPointer) {
        List<Thunk> instructions = new ArrayList<>();

        for (String line : lines) {
            String opcode = line.substring(0, 3);
            String rawOperands = line.substring(4);
            String[] operands = rawOperands.split(", ");
            String operand0 = operands[0];
            Register targetRegister = operand0.equals("a") ? a : b;

            if (operands.length == 1) {
                switch (opcode) {
                    case "hlf":
                        instructions.add(() -> {
                            targetRegister.value >>= 1;
                            instructionPointer.value += 1;
                        });
                        break;
                    case "tpl":
                        instructions.add(() -> {
                            targetRegister.value *= 3;
                            instructionPointer.value += 1;
                        });
                        break;
                    case "inc":
                        instructions.add(() -> {
                            targetRegister.value += 1;
                            instructionPointer.value += 1;
                        });
                        break;
                    case "jmp":
                        int offset = Integer.parseInt(operand0);
                        instructions.add(() -> {
                            instructionPointer.value += offset;
                        });
                        break;
                }

            } else {
                String operand1 = operands[1];
                int offset = Integer.parseInt(operand1);

                switch (opcode) {
                    case "jie":
                        instructions.add(() -> {
                            instructionPointer.value += ((targetRegister.value & 1) == 0) ? offset : 1;
                        });
                        break;
                    case "jio":
                        instructions.add(() -> {
                            instructionPointer.value += targetRegister.value == 1 ? offset : 1;
                        });
                        break;
                }
            }
        }

        return instructions;
    }


    public static int solve(List<Thunk> instructions, Register a, Register b, Register instructionPointer, Register registerToSolve) {
        Thunk instruction = null;

        while (instructionPointer.value < instructions.size() && instructionPointer.value >= 0) {
            instruction = instructions.get(instructionPointer.value);
            instruction.apply();
        }

        return registerToSolve.value;
    }
}

interface Thunk { void apply(); }