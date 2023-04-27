package com.dashuju.media.model.dto;

import lombok.Data;

@Data
public class UploadFileParamsDto {
    /**
     * 文件名称
     */
    private String filename;
    /**
     * 文件类型（文档，音频，视频）
     */
    private String fileType;
    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 标签
     */
    private String tags;
    /**
     * 上传人
     */
    private String username;
    /**
     * 备注
     */
    private String remark;
}
/**
 * @description 上传普通文件的请求参数
 * @author 74667
 * @date 2023/4/23 20:33
 * @version 1.0
 */