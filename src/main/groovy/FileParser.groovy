import groovy.io.FileType


// maybe we can use the google drive?
def inputImagePath = new File("/Users/nathandunn/INCA/ToAnalyze/single_files/")


def singleImagePath = new File("paththere")
def singleNonImagePath = new File("paththere")

def formattedCodes = new File('../../../resources/figshare_formatted_image_files.tsv')
println formattedCodes.absolutePath
println formattedCodes.exists()

def imageFiles = []
def nonImageFiles = []
def filesToCopy = []

def imagePattern=["I","MI","BI"]
def imageFileSuffixes=["tif","png","pdf","jpg","jpeg"]
def noImagePattern=["C","LC","BC","D","M","O","NN"]

formattedCodes.text.readLines().eachWithIndex { line,index ->
    def splitLine = line.split("\t")

    def directory = splitLine[0]
    def code = splitLine[1]
    def note = splitLine.length>2 ? splitLine[2] : ""
    if(imagePattern.contains(code) &&  !note?.toLowerCase()?.contains("multi")){
        imageFiles.add(directory)
    }
    else{
        nonImageFiles.add(directory)
    }
}


println "Image files: " +imageFiles.size()
println "Non image files: " +nonImageFiles.size()

// list contents of directories for each
imageFiles.eachWithIndex { String entry, int i ->
    String fileInput = "${inputImagePath.absolutePath}/${entry}/"
//    println "file input ${fileInput}"
    def dir  = new File(fileInput)
//    println "dir ${dir.absolutePath}"
    def filesToCopyHere = []
    dir.eachFileRecurse (FileType.FILES) { File file ->
        def fileSplit = file.name.toLowerCase().split("\\.")
        def suffix = fileSplit[fileSplit.length-1]
        if(imageFileSuffixes.contains(suffix)){
            filesToCopyHere << file
        }
    }
    if(filesToCopyHere.size()>1){
        println "too many to copy for ${entry} -> ${filesToCopyHere}"
    }
    filesToCopy << filesToCopyHere
}

println filesToCopy.size()
println filesToCopy

// then copy ONLY the files

// then score the separate as 100%


// then create a scoring function to be used in training (just percent correct, but needs to sue that format)



