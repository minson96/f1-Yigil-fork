package kr.co.yigil.travel.interfaces.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.yigil.travel.domain.Spot;
import kr.co.yigil.travel.domain.spot.SpotCommand;
import kr.co.yigil.travel.domain.spot.SpotInfo;
import kr.co.yigil.travel.interfaces.dto.SpotDetailInfoDto;
import kr.co.yigil.travel.interfaces.dto.SpotInfoDto;
import kr.co.yigil.travel.interfaces.dto.request.SpotRegisterRequest;
import kr.co.yigil.travel.interfaces.dto.request.SpotUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T17:11:42+0900",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class SpotMapperImpl implements SpotMapper {

    @Override
    public SpotInfoDto spotToSpotInfoDto(Spot spot) {
        if ( spot == null ) {
            return null;
        }

        SpotInfoDto spotInfoDto = new SpotInfoDto();

        spotInfoDto.setImageUrlList( spot.getAttachFiles().getUrls() );
        spotInfoDto.setOwnerProfileImageUrl( spot.getMember().getProfileImageUrl() );
        spotInfoDto.setOwnerNickname( spot.getMember().getNickname() );
        spotInfoDto.setRate( String.valueOf(spot.getRate()) );
        spotInfoDto.setCreateDate( spot.getCreatedAt().toString() );

        return spotInfoDto;
    }

    @Override
    public SpotDetailInfoDto toSpotDetailInfoDto(SpotInfo.Main spotInfoMain) {
        if ( spotInfoMain == null ) {
            return null;
        }

        SpotDetailInfoDto spotDetailInfoDto = new SpotDetailInfoDto();

        spotDetailInfoDto.setPlaceName( spotInfoMain.getPlaceName() );
        spotDetailInfoDto.setRate( doubleToString( spotInfoMain.getRate() ) );
        spotDetailInfoDto.setPlaceAddress( spotInfoMain.getPlaceAddress() );
        spotDetailInfoDto.setMapStaticImageFileUrl( spotInfoMain.getMapStaticImageFileUrl() );
        List<String> list = spotInfoMain.getImageUrls();
        if ( list != null ) {
            spotDetailInfoDto.setImageUrls( new ArrayList<String>( list ) );
        }
        spotDetailInfoDto.setCreateDate( localDateTimeToString( spotInfoMain.getCreateDate() ) );
        spotDetailInfoDto.setDescription( spotInfoMain.getDescription() );

        return spotDetailInfoDto;
    }

    @Override
    public SpotCommand.ModifySpotRequest toModifySpotRequest(SpotUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        SpotCommand.ModifySpotRequest.ModifySpotRequestBuilder modifySpotRequest = SpotCommand.ModifySpotRequest.builder();

        modifySpotRequest.id( request.getId() );
        modifySpotRequest.rate( request.getRate() );
        modifySpotRequest.description( request.getDescription() );
        modifySpotRequest.originalImages( originalSpotImageListToOriginalSpotImageList( request.getOriginalSpotImages() ) );
        modifySpotRequest.updatedImages( updateSpotImageListToUpdateSpotImageList( request.getUpdateSpotImages() ) );

        return modifySpotRequest.build();
    }

    @Override
    public SpotCommand.RegisterSpotRequest toRegisterSpotRequest(SpotRegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        SpotCommand.RegisterSpotRequest.RegisterSpotRequestBuilder registerSpotRequest = SpotCommand.RegisterSpotRequest.builder();

        registerSpotRequest.registerPlaceRequest( spotRegisterRequestToRegisterPlaceRequest( request ) );
        List<MultipartFile> list = request.getFiles();
        if ( list != null ) {
            registerSpotRequest.files( new ArrayList<MultipartFile>( list ) );
        }
        registerSpotRequest.pointJson( request.getPointJson() );
        registerSpotRequest.title( request.getTitle() );
        registerSpotRequest.description( request.getDescription() );
        registerSpotRequest.rate( request.getRate() );

        return registerSpotRequest.build();
    }

    protected SpotCommand.OriginalSpotImage originalSpotImageToOriginalSpotImage(SpotUpdateRequest.OriginalSpotImage originalSpotImage) {
        if ( originalSpotImage == null ) {
            return null;
        }

        SpotCommand.OriginalSpotImage.OriginalSpotImageBuilder originalSpotImage1 = SpotCommand.OriginalSpotImage.builder();

        originalSpotImage1.imageUrl( originalSpotImage.getImageUrl() );
        originalSpotImage1.index( originalSpotImage.getIndex() );

        return originalSpotImage1.build();
    }

    protected List<SpotCommand.OriginalSpotImage> originalSpotImageListToOriginalSpotImageList(List<SpotUpdateRequest.OriginalSpotImage> list) {
        if ( list == null ) {
            return null;
        }

        List<SpotCommand.OriginalSpotImage> list1 = new ArrayList<SpotCommand.OriginalSpotImage>( list.size() );
        for ( SpotUpdateRequest.OriginalSpotImage originalSpotImage : list ) {
            list1.add( originalSpotImageToOriginalSpotImage( originalSpotImage ) );
        }

        return list1;
    }

    protected SpotCommand.UpdateSpotImage updateSpotImageToUpdateSpotImage(SpotUpdateRequest.UpdateSpotImage updateSpotImage) {
        if ( updateSpotImage == null ) {
            return null;
        }

        SpotCommand.UpdateSpotImage.UpdateSpotImageBuilder updateSpotImage1 = SpotCommand.UpdateSpotImage.builder();

        updateSpotImage1.imageFile( updateSpotImage.getImageFile() );
        updateSpotImage1.index( updateSpotImage.getIndex() );

        return updateSpotImage1.build();
    }

    protected List<SpotCommand.UpdateSpotImage> updateSpotImageListToUpdateSpotImageList(List<SpotUpdateRequest.UpdateSpotImage> list) {
        if ( list == null ) {
            return null;
        }

        List<SpotCommand.UpdateSpotImage> list1 = new ArrayList<SpotCommand.UpdateSpotImage>( list.size() );
        for ( SpotUpdateRequest.UpdateSpotImage updateSpotImage : list ) {
            list1.add( updateSpotImageToUpdateSpotImage( updateSpotImage ) );
        }

        return list1;
    }

    protected SpotCommand.RegisterPlaceRequest spotRegisterRequestToRegisterPlaceRequest(SpotRegisterRequest spotRegisterRequest) {
        if ( spotRegisterRequest == null ) {
            return null;
        }

        SpotCommand.RegisterPlaceRequest.RegisterPlaceRequestBuilder registerPlaceRequest = SpotCommand.RegisterPlaceRequest.builder();

        registerPlaceRequest.mapStaticImageFile( spotRegisterRequest.getMapStaticImageFile() );
        registerPlaceRequest.placeImageFile( spotRegisterRequest.getPlaceImageFile() );
        registerPlaceRequest.placeName( spotRegisterRequest.getPlaceName() );
        registerPlaceRequest.placeAddress( spotRegisterRequest.getPlaceAddress() );
        registerPlaceRequest.placePointJson( spotRegisterRequest.getPlacePointJson() );

        return registerPlaceRequest.build();
    }
}
