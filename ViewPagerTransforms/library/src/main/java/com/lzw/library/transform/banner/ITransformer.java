package com.lzw.library.transform.banner;

/**
 * @Description ViewPager切换动画
 */
public interface ITransformer {

    // 默认
    int TRANSFORMER_DEFAULT = 0x0001;//DefaultTransformer
    // 折叠
    int TRANSFORMER_ACCORDITION = 0x0002;//AccordionTransformer
    // 后到前
    int TRANSFORMER_BG_TO_FORGROUND = 0x0003;//BackgroundToForegroundTransformer
    // 前到后
    int TRANSFORMER_FORGROUND_TO_BG = 0x0004;//ForegroundToBackgroundTransformer
    // 立体进入
    int TRANSFORMER_CUBE_IN = 0x0005;//CubeInTransformer
    // 立体退出
    int TRANSFORMER_CUBE_OUT = 0x0006;//CubeOutTransformer
    // 深度页面
    int TRANSFORMER_DEPTH_PAGE = 0x0007;//DepthPageTransformer
    // 水平翻转
    int TRANSFORMER_FLIP_HORIZONTAL = 0x0008;//FlipHorizontalTransformer
    // 垂直翻转
    int TRANSFORMER_FLIP_VERTICAL = 0x0009;//FlipVerticalTransformer
    // 向下旋转
    int TRANSFORMER_ROTATE_DOWN = 0x0010;//RotateDownTransformer
    // 向上旋转
    int TRANSFORMER_ROTATE_UP = 0x0011;//RotateUpTransformer
    // 叠加
    int TRANSFORMER_STACK = 0x0012;//StackTransformer
    // 方块
    int TRANSFORMER_TABLET = 0x0013;//TabletTransformer
    // 放大进出
    int TRANSFORMER_SCALE_IN_OUT = 0x0014;//ScaleInOutTransformer
    // 放大
    int TRANSFORMER_ZOOM_IN = 0x0015;//ZoomInTransformer
    // 缩小
    int TRANSFORMER_ZOOM_OUT = 0x0100;//ZoomOutTranformer
    // 外面缩小
    int TRANSFORMER_ZOOM_OUT_SLIDE = 0x0101;//ZoomOutSlideTransformer
    // 3D画廊
    int TRANSFORMER_GALLERY_3D = 0x0102;//Gallery3DTransformer
    // 透明度变化
    int TRANSFORMER_ALPHA_CHANGE = 0x0103;//AlphaPageTransformer

}