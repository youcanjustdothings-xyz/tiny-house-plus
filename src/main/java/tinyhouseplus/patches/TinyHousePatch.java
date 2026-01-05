package tinyhouseplus.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.TinyHouse;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.Settings;

public class TinyHousePatch {
    
    // Patch to grant extra common relic on equip
    @SpirePatch(
        clz = TinyHouse.class,
        method = "onEquip"
    )
    public static class GrantExtraRelic {
        @SpirePostfixPatch
        public static void Postfix(TinyHouse __instance) {
            // Get a random common relic
            AbstractRelic randomCommonRelic = AbstractDungeon.returnRandomRelic(AbstractRelic.RelicTier.COMMON);
            
            // Directly add the relic to the player instead of using spawnRelicAndObtain
            AbstractDungeon.player.relics.add(randomCommonRelic);
            randomCommonRelic.instantObtain(AbstractDungeon.player, AbstractDungeon.player.relics.size() - 1, false);
        }
    }
}

