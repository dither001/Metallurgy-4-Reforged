package it.hurts.metallurgy_5.material;

import it.hurts.metallurgy_5.Metallurgy_5;
import it.hurts.metallurgy_5.block.BlockOreDict;
import it.hurts.metallurgy_5.block.FluidBlockBase;
import it.hurts.metallurgy_5.fluid.FluidMolten;
import it.hurts.metallurgy_5.item.ItemOreDict;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Metal {
    private final MetalStats stats;

    private final ItemOreDict ingot, dust;
    private final BlockOreDict ore, block;
    private final FluidMolten molten;
    private FluidBlockBase fluidBlock;
    private ItemTool.ToolMaterial toolMat;
    private ItemArmor.ArmorMaterial armorMat;

    public Metal(MetalStats stats, ItemOreDict ingot, ItemOreDict dust, BlockOreDict ore, BlockOreDict block, FluidMolten molten) {
        this.stats = stats;
        this.ingot = ingot;
        this.dust = dust;
        this.ore = ore;
        this.block = block;
        this.molten = molten;
        ModMetals.metalList.add(this);
    }

    public ItemTool.ToolMaterial getToolMaterial() {
        if (toolMat == null) {
            ToolStats tStats = stats.getToolStats();
            if(tStats == null) {
                throw new UnsupportedOperationException("No Tool Stats Loaded");
            }
            this.toolMat = EnumHelper.addToolMaterial(stats.getName().toUpperCase(), tStats.getHarvestLevel(), tStats.getMaxUses(), tStats.getEfficiency(), tStats.getDamage(), tStats.getToolMagic());
        }
        return toolMat;
    }

    public ItemArmor.ArmorMaterial getArmorMaterial() {
        if (armorMat == null) {
            ArmorStats aStats = stats.getArmorStats();
            if(aStats == null) {
                throw new UnsupportedOperationException("No Armor Stats Loaded");
            }
            this.armorMat = EnumHelper.addArmorMaterial(stats.getName().toUpperCase(), Metallurgy_5.MODID + ":" + stats.getName(), aStats.getDurability(), aStats.getDamageReduction(), aStats.getArmorMagic(), aStats.getEquipSound(), aStats.getToughness());
        }
        return armorMat;
    }

    public void initFluidBlock() {
        fluidBlock = new FluidBlockBase(molten, Material.LAVA, "molten_" + stats.getName());
    }

    @Nonnull
    public MetalStats getStats() {
        return stats;
    }

    @Nonnull
    public ItemOreDict getIngot() {
        return ingot;
    }

    @Nonnull
    public ItemOreDict getDust() {
        return dust;
    }

    @Nullable
    public BlockOreDict getOre() {
        return ore;
    }

    @Nonnull
    public BlockOreDict getBlock() {
        return block;
    }

    @Nonnull
    public FluidMolten getMolten() {
        return molten;
    }

    @Nonnull
    public FluidBlockBase getFluidBlock() {
        return fluidBlock;
    }
}