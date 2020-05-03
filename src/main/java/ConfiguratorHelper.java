public class ConfiguratorHelper {
    private Ram ram;
    private Processor processor;
    private GraphicCard graphicCard;

    public ConfiguratorHelper() {
    }

    public ConfiguratorHelper(Ram ram, Processor processor, GraphicCard graphicCard) {
        this.ram = ram;
        this.processor = processor;
        this.graphicCard = graphicCard;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }
}
