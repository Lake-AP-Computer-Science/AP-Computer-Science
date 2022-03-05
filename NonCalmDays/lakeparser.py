#lake parser

R = []

while (True):
    c = input()
    
    if c == "exit":
        break
    
    R.append(c)
    
for elem in R:
    print("crimes.put(\"" + elem.replace("–", "\", ") + ");")
