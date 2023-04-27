package com.dashuju.media.service;


import com.dashuju.base.model.PageParams;
import com.dashuju.base.model.PageResult;
import com.dashuju.base.model.RestResponse;
import com.dashuju.media.model.dto.QueryMediaParamsDto;
import com.dashuju.media.model.dto.UploadFileParamsDto;
import com.dashuju.media.model.dto.UploadFileResultDto;
import com.dashuju.media.model.po.MediaFiles;

import java.io.File;

/**
 * @description 媒资文件管理业务类
 */
public interface MediaFileService {

    /**
     * @param pageParams          分页参数
     * @param queryMediaParamsDto 查询条件
     * @description 媒资文件查询方法
     */
    PageResult<MediaFiles> queryMediaFiels(Long companyId, PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

    /**
     * 文件上传
     * @param companyId
     * @param uploadFileParamsDto
     * @param localFilePath
     * @return
     */
    UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);
    /**
     * @description 将文件信息添加到文件表
     * @param companyId  机构id
     * @param fileMd5  文件md5值
     * @param uploadFileParamsDto  上传文件的信息
     * @param bucket  桶
     * @param objectName 对象名称
     * @return MediaFiles
     */
    MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);

    //---------------------------------------------------------------------------------\\

    /**
     * @description 检查文件是否存在
     * @param fileMd5 文件的md5
     * @return RestResponse<Boolean> false不存在，true存在
     */
    RestResponse<Boolean> checkFile(String fileMd5);

    /**
     * @description 检查分块是否存在
     * @param fileMd5  文件的md5
     * @param chunkIndex  分块序号
     * @return RestResponse<Boolean> false不存在，true存在
     */
    RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

    /**
     * @description 上传分块
     * @param fileMd5  文件md5
     * @param chunk  分块序号
     * @param localChunkFilePath  分块文件本地路径
     * @return RestResponse
     */
    RestResponse uploadChunk(String fileMd5,int chunk,String localChunkFilePath);

    /**
     * @description 合并分块
     * @param companyId  机构id
     * @param fileMd5  文件md5
     * @param chunkTotal 分块总和
     * @param uploadFileParamsDto 文件信息
     * @return RestResponse
     */
    RestResponse mergechunks(Long companyId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);

    void deleteMiniOVideo(String mediaId);
    boolean addMediaFilesToMinIO(String localFilePath,String mimeType,String bucket, String objectName);

    File downloadFileFromMinIO(String bucket, String objectName);
    MediaFiles getFileById(String mediaId);
}
