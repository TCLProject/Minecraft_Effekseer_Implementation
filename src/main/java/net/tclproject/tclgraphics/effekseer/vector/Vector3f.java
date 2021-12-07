package net.tclproject.tclgraphics.effekseer.vector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.tclproject.tclgraphics.PortUtil;

public final class Vector3f {
   public static Vector3f field_229178_a_ = new Vector3f(-1.0F, 0.0F, 0.0F);
   public static Vector3f field_229179_b_ = new Vector3f(1.0F, 0.0F, 0.0F);
   public static Vector3f field_229180_c_ = new Vector3f(0.0F, -1.0F, 0.0F);
   public static Vector3f field_229181_d_ = new Vector3f(0.0F, 1.0F, 0.0F);
   public static Vector3f field_229182_e_ = new Vector3f(0.0F, 0.0F, -1.0F);
   public static Vector3f field_229183_f_ = new Vector3f(0.0F, 0.0F, 1.0F);
   private float field_229184_g_;
   private float field_229185_h_;
   private float field_229186_i_;

   public Vector3f() {
   }

   public Vector3f(float p_i48098_1_, float p_i48098_2_, float p_i48098_3_) {
      this.field_229184_g_ = p_i48098_1_;
      this.field_229185_h_ = p_i48098_2_;
      this.field_229186_i_ = p_i48098_3_;
   }

   public boolean equals(Object p_equals_1_) {
      if (this == p_equals_1_) {
         return true;
      } else if (p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         Vector3f vector3f = (Vector3f)p_equals_1_;
         if (Float.compare(vector3f.field_229184_g_, this.field_229184_g_) != 0) {
            return false;
         } else if (Float.compare(vector3f.field_229185_h_, this.field_229185_h_) != 0) {
            return false;
         } else {
            return Float.compare(vector3f.field_229186_i_, this.field_229186_i_) == 0;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int i = Float.floatToIntBits(this.field_229184_g_);
      i = 31 * i + Float.floatToIntBits(this.field_229185_h_);
      return 31 * i + Float.floatToIntBits(this.field_229186_i_);
   }

   public float func_195899_a() {
      return this.field_229184_g_;
   }

   public float func_195900_b() {
      return this.field_229185_h_;
   }

   public float func_195902_c() {
      return this.field_229186_i_;
   }

   @SideOnly(Side.CLIENT)
   public void func_195898_a(float p_195898_1_) {
      this.field_229184_g_ *= p_195898_1_;
      this.field_229185_h_ *= p_195898_1_;
      this.field_229186_i_ *= p_195898_1_;
   }

   @SideOnly(Side.CLIENT)
   public void func_229192_b_(float p_229192_1_, float p_229192_2_, float p_229192_3_) {
      this.field_229184_g_ *= p_229192_1_;
      this.field_229185_h_ *= p_229192_2_;
      this.field_229186_i_ *= p_229192_3_;
   }

   @SideOnly(Side.CLIENT)
   public void func_195901_a(float p_195901_1_, float p_195901_2_) {
      this.field_229184_g_ = PortUtil.func_76131_a(this.field_229184_g_, p_195901_1_, p_195901_2_);
      this.field_229185_h_ = PortUtil.func_76131_a(this.field_229185_h_, p_195901_1_, p_195901_2_);
      this.field_229186_i_ = PortUtil.func_76131_a(this.field_229186_i_, p_195901_1_, p_195901_2_);
   }

   public void func_195905_a(float p_195905_1_, float p_195905_2_, float p_195905_3_) {
      this.field_229184_g_ = p_195905_1_;
      this.field_229185_h_ = p_195905_2_;
      this.field_229186_i_ = p_195905_3_;
   }

   @SideOnly(Side.CLIENT)
   public void func_195904_b(float p_195904_1_, float p_195904_2_, float p_195904_3_) {
      this.field_229184_g_ += p_195904_1_;
      this.field_229185_h_ += p_195904_2_;
      this.field_229186_i_ += p_195904_3_;
   }

   @SideOnly(Side.CLIENT)
   public void func_229189_a_(Vector3f p_229189_1_) {
      this.field_229184_g_ += p_229189_1_.field_229184_g_;
      this.field_229185_h_ += p_229189_1_.field_229185_h_;
      this.field_229186_i_ += p_229189_1_.field_229186_i_;
   }

   @SideOnly(Side.CLIENT)
   public void func_195897_a(Vector3f p_195897_1_) {
      this.field_229184_g_ -= p_195897_1_.field_229184_g_;
      this.field_229185_h_ -= p_195897_1_.field_229185_h_;
      this.field_229186_i_ -= p_195897_1_.field_229186_i_;
   }

   @SideOnly(Side.CLIENT)
   public float func_195903_b(Vector3f p_195903_1_) {
      return this.field_229184_g_ * p_195903_1_.field_229184_g_ + this.field_229185_h_ * p_195903_1_.field_229185_h_ + this.field_229186_i_ * p_195903_1_.field_229186_i_;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_229194_d_() {
      float f = this.field_229184_g_ * this.field_229184_g_ + this.field_229185_h_ * this.field_229185_h_ + this.field_229186_i_ * this.field_229186_i_;
      if ((double)f < 1.0E-5D) {
         return false;
      } else {
         float f1 = PortUtil.func_226165_i_(f);
         this.field_229184_g_ *= f1;
         this.field_229185_h_ *= f1;
         this.field_229186_i_ *= f1;
         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_195896_c(Vector3f p_195896_1_) {
      float f = this.field_229184_g_;
      float f1 = this.field_229185_h_;
      float f2 = this.field_229186_i_;
      float f3 = p_195896_1_.func_195899_a();
      float f4 = p_195896_1_.func_195900_b();
      float f5 = p_195896_1_.func_195902_c();
      this.field_229184_g_ = f1 * f5 - f2 * f4;
      this.field_229185_h_ = f2 * f3 - f * f5;
      this.field_229186_i_ = f * f4 - f1 * f3;
   }

   @SideOnly(Side.CLIENT)
   public void func_229188_a_(Matrix3f p_229188_1_) {
      float f = this.field_229184_g_;
      float f1 = this.field_229185_h_;
      float f2 = this.field_229186_i_;
      this.field_229184_g_ = p_229188_1_.field_226097_a_ * f + p_229188_1_.field_226098_b_ * f1 + p_229188_1_.field_226099_c_ * f2;
      this.field_229185_h_ = p_229188_1_.field_226100_d_ * f + p_229188_1_.field_226101_e_ * f1 + p_229188_1_.field_226102_f_ * f2;
      this.field_229186_i_ = p_229188_1_.field_226103_g_ * f + p_229188_1_.field_226104_h_ * f1 + p_229188_1_.field_226105_i_ * f2;
   }

   public void func_214905_a(Quaternion p_214905_1_) {
      Quaternion quaternion = new Quaternion(p_214905_1_);
      quaternion.func_195890_a(new Quaternion(this.func_195899_a(), this.func_195900_b(), this.func_195902_c(), 0.0F));
      Quaternion quaternion1 = new Quaternion(p_214905_1_);
      quaternion1.func_195892_e();
      quaternion.func_195890_a(quaternion1);
      this.func_195905_a(quaternion.func_195889_a(), quaternion.func_195891_b(), quaternion.func_195893_c());
   }

   @SideOnly(Side.CLIENT)
   public void func_229190_a_(Vector3f p_229190_1_, float p_229190_2_) {
      float f = 1.0F - p_229190_2_;
      this.field_229184_g_ = this.field_229184_g_ * f + p_229190_1_.field_229184_g_ * p_229190_2_;
      this.field_229185_h_ = this.field_229185_h_ * f + p_229190_1_.field_229185_h_ * p_229190_2_;
      this.field_229186_i_ = this.field_229186_i_ * f + p_229190_1_.field_229186_i_ * p_229190_2_;
   }

   @SideOnly(Side.CLIENT)
   public Quaternion func_229193_c_(float p_229193_1_) {
      return new Quaternion(this, p_229193_1_, false);
   }

   @SideOnly(Side.CLIENT)
   public Quaternion func_229187_a_(float p_229187_1_) {
      return new Quaternion(this, p_229187_1_, true);
   }

   @SideOnly(Side.CLIENT)
   public Vector3f func_229195_e_() {
      return new Vector3f(this.field_229184_g_, this.field_229185_h_, this.field_229186_i_);
   }

   public String toString() {
      return "[" + this.field_229184_g_ + ", " + this.field_229185_h_ + ", " + this.field_229186_i_ + "]";
   }

    // Forge start
    public Vector3f(float[] values) {
        set(values);
    }
    public void set(float[] values) {
        this.field_229184_g_ = values[0];
        this.field_229185_h_ = values[1];
        this.field_229186_i_ = values[2];
    }
    public void setX(float x) { this.field_229184_g_ = x; }
    public void setY(float y) { this.field_229185_h_ = y; }
    public void setZ(float z) { this.field_229186_i_ = z; }
}
