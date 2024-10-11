package com.example.main.global.common.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;


@Tag(name = "intern", description = "인턴 모집 조회")
public interface SwaggerIntern {

    @ApiResponse({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK, 성공!",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = //보내는 response
                            )

                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "인턴을 조회할 수 없습니다.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = // ErrorResponse.class
                            )
                    )
            )

    })
    @Operation(
            summary = "인턴을 지원한 학생 목록 조회 API",
            description = "학생의 지원 받은 시간 순으로 지원 목록 검색합니다"
    )
    // dto ( 쓰고 ) ex) internResponse getInterResponse(String internId)

}
