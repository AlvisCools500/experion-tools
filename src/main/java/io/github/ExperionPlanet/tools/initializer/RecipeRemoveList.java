package io.github.ExperionPlanet.tools.initializer;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeRemoveList {
    public static final Logger LOGGER = LoggerFactory.getLogger(RecipeRemoveList.class);


    public static final List<String> REMOVE_LIST = ImmutableList.of();

    public static final ImmutableList<Identifier> GetIdList() {
        List<Identifier> idList = new ArrayList<>();

        for (String v : REMOVE_LIST) {
            if (v.contains("*")) {
                for (int i = 1; i <= 5; i ++) {
                    String toolSTR = "sword";

                    if (i == 2) {
                        toolSTR = "axe";
                    } else if (i == 3) {
                        toolSTR = "pickaxe";
                    } else if (i == 4) {
                        toolSTR = "shovel";
                    } else if (i == 5) {
                        toolSTR = "hoe";
                    }

                    String res = v.replace("*",toolSTR);

                    idList.add(Identifier.of("minecraft", res));

                    RecipeRemoveList.LOGGER.info(res);
                }
            }else {
                idList.add(Identifier.of("minecraft",v));
                RecipeRemoveList.LOGGER.info(v);
            }
        }

        return ImmutableList.copyOf(idList);
    }
}
