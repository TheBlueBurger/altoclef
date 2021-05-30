package adris.altoclef.tasks.resources;


import adris.altoclef.AltoClef;
import adris.altoclef.tasks.MineAndCollectTask;
import adris.altoclef.tasks.ResourceTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.MiningRequirement;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;


public class CollectCobblestoneTask extends ResourceTask {
    private final int count;

    public CollectCobblestoneTask(int targetCount) {
        super(Items.COBBLESTONE, targetCount);
        count = targetCount;
    }

    @Override
    protected boolean shouldAvoidPickingUp(AltoClef mod) {
        return false;
    }

    @Override
    protected void onResourceStart(AltoClef mod) {

    }

    @Override
    protected Task onResourceTick(AltoClef mod) {
        return new MineAndCollectTask(Items.COBBLESTONE, 1, new Block[]{ Blocks.STONE, Blocks.COBBLESTONE }, MiningRequirement.WOOD);
    }

    @Override
    protected void onResourceStop(AltoClef mod, Task interruptTask) {

    }

    @Override
    protected boolean isEqualResource(ResourceTask obj) {
        if (obj instanceof CollectCobblestoneTask) {
            CollectCobblestoneTask other = (CollectCobblestoneTask) obj;
            return other.count == count;
        }
        return false;
    }

    @Override
    protected String toDebugStringName() {
        return "Collect Cobblestone";
    }
}
