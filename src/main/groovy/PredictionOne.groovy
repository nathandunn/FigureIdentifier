//import org.deeplearning4j.nn.graph.ComputationGraph
//import org.deeplearning4j.zoo.PretrainedType
import org.deeplearning4j.zoo.ZooModel
import org.deeplearning4j.zoo.model.AlexNet
import org.deeplearning4j.zoo.model.ResNet50

////import org.deeplearning4j.zoo.model.ResNet50
//import org.deeplearning4j.zoo.model.VGG16

class PredictionOne {

    def runPrediction(){
        println "running a prection "
        ZooModel zooModel = new AlexNet()
//        ComputationGraph pretrainedNet = (ComputationGraph) zooModel.initPretrained(PretrainedType.IMAGENET);
//        println pretrainedNet.summary()
    }
}
