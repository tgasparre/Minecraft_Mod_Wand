package net.tati.practicemod.item.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class MagicWandItem extends Item {
    private static final Map<Block, Block> Wand_Map =
            Map.of(
                    Blocks.COPPER_ORE, Blocks.IRON_ORE,
                    Blocks.IRON_ORE, Blocks.DIAMOND_ORE,
                    Blocks.DIAMOND_ORE, Blocks.NETHERITE_BLOCK
            );

    public MagicWandItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (Wand_Map.containsKey(clickedBlock))
        {
            if (!level.isClientSide())
            {
                level.setBlockAndUpdate(pContext.getClickedPos(), Wand_Map.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

            }
        }
        return InteractionResult.SUCCESS;
    }
}
