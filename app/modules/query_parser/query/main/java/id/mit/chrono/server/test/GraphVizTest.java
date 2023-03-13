package id.mit.chrono.server.test;

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.Node;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Attributes.attr;
import static guru.nidi.graphviz.model.Factory.*;

public class GraphVizTest {

    public static void main(String[] args) {

//        Graph g = graph("example1").directed()
//                .graphAttr().with(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT))
//                .nodeAttr().with(Font.name("arial"))
//                .linkAttr().with("class", "link-class")
//                .with(
//                        node("a").with(Color.RED).link(node("b")),
//                        node("b").link(
//                                to(node("c")).with(attr("weight", 5), Style.DASHED)
//                        )
//                );
//
//
//
//        try {
//
//            Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("example/ex1.png"));
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }

//        MutableGraph g = mutGraph("queryset").setDirected(true).graphAttrs().add(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT)).use((gr, ctx) -> {
////            mutNode("b");
////            mutNode("a").addLink(mutNode("b"));
//            // 1st layer
//            mutNode("MINOS");
//            mutNode("UME");
//            mutNode("ZTE").addLink(mutNode("MINOS")).addLink(mutNode("UME"));
//
//            // 2nd layer
//            mutNode("2G");
//            mutNode("3G");
//            mutNode("4G");
//            mutNode("MINOS")
//                    .addLink(mutNode("2G"))
//                    .addLink(mutNode("3G"))
//                    .addLink(mutNode("4G"));
//            mutNode("UME")
//                    .addLink(mutNode("2G"))
//                    .addLink(mutNode("3G"))
//                    .addLink(mutNode("4G"));
//
//            // 3rd layer
//            mutNode("Extract");
//            mutNode("2G").addLink(mutNode("Extract"));
//            mutNode("3G").addLink(mutNode("Extract"));
//            mutNode("4G").addLink(mutNode("Extract"));
//        });
//
//        try {
//            Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("example/ex2.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Node
                // 1st layer node
                zte = node("ZTE").with(Shape.ELLIPSE),

                // 2nd layer node
                minos = node("MINOS").with(Shape.ELLIPSE),
                ume = node("UME").with(Shape.ELLIPSE),

                // 3rd layer node
                _2g = node("2G").with(Shape.ELLIPSE),
                _3g = node("3G").with(Shape.ELLIPSE),
                _4g = node("4G").with(Shape.ELLIPSE),

                // 4th layer node
                extract = node("Extract"),

                // 5th layer node
                minos_2g_controllergsm = node("^Controller-gsm_radio.*")
                        .with(Label.html("<b>^Controller-gsm_radio.*</b>")),
                minos_2g_controlleruni = node("^Controller-uni_ground.*"),
                minos_3g_controllerumts = node("^Controller-umts_radio.*")
                        .with(Label.html("<b>^Controller-umts_radio.*</b>")),
                minos_3g_controlleruni = node("^Controller-uni_ground.*"),
                minos_4g_sdrfdd = node("^SDR-fdd_radio.*")
                        .with(Label.html("<b>^SDR-fdd_radio.*</b>")),
                minos_4g_sdrtdd = node("^SDR-tdd_radio.*")
                        .with(Label.html("<b>^SDR-tdd_radio.*</b>")),
                minos_4g_sdrnb = node("^SDR-nb_radio.*")
                        .with(Label.html("<b>^SDR-nb_radio.*</b>")),
                minos_4g_sdrsdr = node("^SDR-sdr.*");

        Graph graph = graph("queryset").directed()
                .graphAttr()
                .with(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT))
                .with(
                        zte.link(
                                to(minos),
                                to(ume)
                        ),
                        ume.link(
                                to(_2g.link(extract)),
                                to(_3g.link(extract)),
                                to(_4g.link(extract))
                        ),
                        minos.link(
                                to(_2g.link(extract)),
                                to(_3g.link(extract)),
                                to(_4g.link(extract))
                        ),
                        _2g.link(to(extract)),
                        _3g.link(to(extract)),
                        _4g.link(to(extract)),
                        extract.link(
                                to(minos_2g_controllergsm),
                                to(minos_2g_controlleruni)
                        ),
                        extract.link(
                                to(minos_3g_controllerumts),
                                to(minos_3g_controlleruni)
                        ),
                        extract.link(
                                to(minos_4g_sdrfdd),
                                to(minos_4g_sdrtdd),
                                to(minos_4g_sdrnb),
                                to(minos_4g_sdrsdr)
                        )
                );

        try {

            Graphviz.fromGraph(graph).render(Format.PNG).toFile(new File("example/queryset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
