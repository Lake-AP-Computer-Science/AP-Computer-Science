import os

VariableName = input("Name: \n")
VariableType = input("Type: \n")

with open(str(os.path.abspath(__file__)).replace("Main.py", "Output.java"), "w+") as f:
    f.write(
"""
//Get __VarName__
public void  __Type__ get__VarName__()
{
    return this.__VarName__;
}

//Set __VarName__
public set__VarName__(__Type__ __VarName__)
{
    this.__VarName__ = __VarName__;
}
""".replace("__VarName__", VariableName).replace("__Type__", VariableType)
)