


def f = new File('../../../resources/figshare_formatted_image_files.tsv')
println f.absolutePath
println f.exists()

def imageFiles = []
def nonImageFiles = []

def imagePattern=["I"]
def noImagePattern=["D"]

f.text.readLines().eachWithIndex { line,index ->
    def splitLine = line.split("\t")
//    println index + "(1)" + splitLine[0] + "(2)" + splitLine[1]
//    if(splitLine.length>2){
//        println index + "(3)" + splitLine[2]
//    }
    if(imagePattern.contains(splitLine[1])){
        imageFiles.add(splitLine[0])
    }
    else{
        imageFiles.add(splitLine[0])
    }
}

// then copy ONLY the files


// then score the separate as 100%


// then create a scoring function to be used in training (just percent correct, but needs to sue that format)



