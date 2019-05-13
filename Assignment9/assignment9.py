import sys
import operator
#print("Number or arguments: " ,len(sys.argv) ) 
if len(sys.argv) == 3:
    storyFile = sys.argv[1]
    skippedFile = sys.argv[2]
    print("Story file name: ", storyFile)
    print("Skipped Words file name: ", skippedFile)
else :
    print("Not enough arguments provided to run the scrypt. Please call using the story file name and the skipper words list as .txt files in that order")
    quit()

erasures = ['\n','\t','.','?','!',',',';',':','\'','\"']

with open(skippedFile,'r') as skippers:
    arraySkip = []
    for line in skippers:
        line.lower()
        arraySkip += line.split(",")
    print("Skip words:" ,arraySkip)


checker = True
arrayStoryFinal = []
with open(storyFile, 'r') as story:
    arrayStory = []
    for line in story:
        line = line.lower()
        for character in erasures:
                line = line.replace(character,"")
        arrayStory += line.split()
    for text in arrayStory:
        #print(text)
        #print("-----------------------------")
        checker = True
        for word in arraySkip:
            if(word == text):
                checker = False
                #print("Checker is False")
                #arrayStoryFinal = arrayStoryFinal
                #print("Word == text")
                #print("Word:" , word)
                #print("Text:" , text)
            else:
                pass  
                #print("Checker is true")
        #print("-----------------------------")
        #print(checker)
        if checker:
            #print("Here2")
            #print(text)
            arrayStoryFinal.append(text)
            checker = True
                
            

#print(arrayStoryFinal)        

repeats = {}

if len(arrayStoryFinal) == 1:
    ##print("There is only 1 word in this story...")
    quit()
for idx, word in enumerate(arrayStoryFinal):
    if idx+1 < len(arrayStoryFinal):
        word_pair = word, arrayStoryFinal[idx+1]
        if word_pair in repeats:
            repeats[word_pair]+=1
        else: 
            repeats[word_pair] = 1

count = 0
print("The five most frequently occurring word pairs are:")
for k,v in sorted(repeats.items(), key = lambda item: item[1], reverse = True):
    if count < 5:
        print("%s: %s" % (k,v))
    count+=1

