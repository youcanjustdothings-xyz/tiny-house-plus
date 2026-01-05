package tinyhouseplus;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import basemod.BaseMod;
import basemod.interfaces.RelicGetSubscriber;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.TinyHouse;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpireInitializer
public class TinyHousePlusMod implements RelicGetSubscriber {
    
    private static boolean grantingExtraRelic = false;
    
    public static void initialize() {
        new TinyHousePlusMod();
    }
    
    public TinyHousePlusMod() {
        BaseMod.subscribe(this);
    }
    
    @Override
    public void receiveRelicGet(AbstractRelic relic) {
        // Prevent recursive calls when granting the extra relic
        if (grantingExtraRelic) {
            return;
        }
        
        // Check if the relic obtained is Tiny House
        if (relic instanceof TinyHouse) {
            grantingExtraRelic = true;
            
            // Get and grant a random common relic
            AbstractRelic extraRelic = AbstractDungeon.returnRandomRelic(AbstractRelic.RelicTier.COMMON);
            extraRelic.instantObtain();
            
            grantingExtraRelic = false;
        }
    }
}

