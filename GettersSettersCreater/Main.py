import os

UseUpperCamel = False
UseComments = False

with open(str(os.path.abspath(__file__)).replace("Main.py", "") + "Configs.txt", "r") as f:

    List = [x.strip("\n") for x in f.readlines()]

    print(List)

    UseUpperCamel = bool(int(List[0]))
    UseComments = bool(int(List[1]))

print(UseUpperCamel)
print(UseComments)

VariableName = input("Name: \n")
VariableType = input("Type: \n")

with open(str(os.path.abspath(__file__)).replace("Main.py", "Output.java"), "w+") as f:
    f.write(
"""
/*Get __VarName__*/
public __Type__ __Gg__et__VarName__()
{
    return this.__VarName__;
}

/*Set __VarName__*/
public void __Ss__et__VarName__(__Type__ __VarName__)
{
    this.__VarName__ = __VarName__;
}
""".replace("/*Set __VarName__*/", "/*Set __VarName__*/" if UseComments else "").replace("/*Get __VarName__*/", "/*Get __VarName__*/" if UseComments else "").replace("__VarName__", VariableName).replace("__Type__", VariableType).replace("__Ss__", "S" if UseUpperCamel else "s").replace("__Gg__", "G" if UseUpperCamel else "g")
)