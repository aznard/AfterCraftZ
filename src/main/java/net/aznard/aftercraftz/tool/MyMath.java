package net.aznard.aftercraftz.tool;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

public class MyMath {

    // Vérifie si b est entre a et c
    public static boolean isBetween(double a, double b, double c) {
        return (b - a) * (c - b) >= 0;
    }

    // Vérifie si un point 2D est à l'intérieur d'un rectangle défini par 4 coins
    public static boolean isPointInsideRect2d(Vec2f m, Vec2f a, Vec2f b, Vec2f c, Vec2f d) {
        float areaRect = 0.5f * Math.abs((a.y - c.y) * (d.x - b.x) + (b.y - d.y) * (a.x - c.x));
        float abm = 0.5f * Math.abs(a.x * (b.y - m.y) + b.x * (m.y - a.y) + m.x * (a.y - b.y));
        float bcm = 0.5f * Math.abs(b.x * (c.y - m.y) + c.x * (m.y - b.y) + m.x * (b.y - c.y));
        float cdm = 0.5f * Math.abs(c.x * (d.y - m.y) + d.x * (m.y - c.y) + m.x * (c.y - d.y));
        float dam = 0.5f * Math.abs(d.x * (a.y - m.y) + a.x * (m.y - d.y) + m.x * (d.y - a.y));
        return (abm + bcm + cdm + dam) < areaRect;
    }

    // Prépare des vecteurs pour vérifier si un point est dans une vue caméra
    public static ArrayList<Vec3d> prepIsPointInsideRect3d(MinecraftClient client, Vec3d tl, Vec3d bl, Vec3d br) {
        assert client.player != null;
        Vec3d lookVector = client.player.getRotationVec(1.0F);

        Vec3d p5 = tl.subtract(lookVector.multiply(200));
        Vec3d p1 = bl.subtract(lookVector.multiply(200));
        Vec3d p4 = br.subtract(lookVector.multiply(200));
        Vec3d p2 = bl.add(lookVector.multiply(200));

        Vec3d u = p1.subtract(p4).crossProduct(p1.subtract(p5));
        Vec3d v = p1.subtract(p2).crossProduct(p1.subtract(p5));
        Vec3d w = p1.subtract(p2).crossProduct(p1.subtract(p4));

        ArrayList<Vec3d> uvwp = new ArrayList<>(7);
        uvwp.add(u);
        uvwp.add(v);
        uvwp.add(w);
        uvwp.add(p1);
        uvwp.add(p2);
        uvwp.add(p4);
        uvwp.add(p5);
        return uvwp;
    }

    public static boolean isPointInsideRect3d(List<Vec3d> uvwp, Vec3d x) {
        if (uvwp == null || uvwp.size() < 7) return false;

        Vec3d u = uvwp.get(0);
        Vec3d v = uvwp.get(1);
        Vec3d w = uvwp.get(2);
        Vec3d p1 = uvwp.get(3);
        Vec3d p2 = uvwp.get(4);
        Vec3d p4 = uvwp.get(5);
        Vec3d p5 = uvwp.get(6);

        double up1 = u.dotProduct(p1);
        double up2 = u.dotProduct(p2);
        double vp1 = v.dotProduct(p1);
        double vp4 = v.dotProduct(p4);
        double wp1 = w.dotProduct(p1);
        double wp5 = w.dotProduct(p5);

        double ux = u.dotProduct(x);
        double vx = v.dotProduct(x);
        double wx = w.dotProduct(x);

        return isBetween(up1, ux, up2) &&
                isBetween(vp1, vx, vp4) &&
                isBetween(wp1, wx, wp5);
    }

    public static Vec3d addVector3d(Vec3d vec, Vec3d unitVec, float scale) {
        return vec.add(unitVec.multiply(scale));
    }

    public static boolean rayIntersectsAABBCustom(Vec3d origin, Vec3d rayVector, Box aabb) {
        double invDirX = 1.0 / rayVector.x;
        double invDirY = 1.0 / rayVector.y;
        double invDirZ = 1.0 / rayVector.z;

        double t1 = (aabb.minX - origin.x) * invDirX;
        double t2 = (aabb.maxX - origin.x) * invDirX;
        double t3 = (aabb.minY - origin.y) * invDirY;
        double t4 = (aabb.maxY - origin.y) * invDirY;
        double t5 = (aabb.minZ - origin.z) * invDirZ;
        double t6 = (aabb.maxZ - origin.z) * invDirZ;

        double tmin = Math.max(Math.max(Math.min(t1, t2), Math.min(t3, t4)), Math.min(t5, t6));
        double tmax = Math.min(Math.min(Math.max(t1, t2), Math.max(t3, t4)), Math.max(t5, t6));

        return tmax >= 0 && tmin <= tmax;
    }

    public static Vec2f rotateCoords(float x, float y, double deg) {
        double rad = Math.toRadians(deg);
        float cosRad = (float) Math.cos(rad);
        float sinRad = (float) Math.sin(rad);
        return new Vec2f(x * cosRad - y * sinRad, y * cosRad + x * sinRad);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static BlockPos getXZRangeLimitedBlockPos(BlockPos originPos, BlockPos targetPos, float range) {
        double deltaX = targetPos.getX() - originPos.getX();
        double deltaZ = targetPos.getZ() - originPos.getZ();
        double distanceSquared = deltaX * deltaX + deltaZ * deltaZ;
        double rangeSquared = range * range;

        if (distanceSquared <= rangeSquared) {
            return targetPos;
        }

        double scale = range / Math.sqrt(distanceSquared);
        int x3 = (int) Math.round(originPos.getX() + scale * deltaX);
        int z3 = (int) Math.round(originPos.getZ() + scale * deltaZ);

        return new BlockPos(x3, originPos.getY(), z3);
    }

    public static int randRangeInt(int min, int max) {
        return Random.create().nextBetween(min, max);
    }
}

